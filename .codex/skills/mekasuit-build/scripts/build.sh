#!/usr/bin/env bash
set -euo pipefail

skill_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
repo_root="$(cd "$skill_dir/../../.." && pwd)"
tools_root=/opt/minecraft-tools
gradle_home="$tools_root/gradle-home"
gradle_bin="$tools_root/gradle-8.12/bin/gradle"
fernflower_zip="$gradle_home/caches/retro_futura_gradle/mcp/fernflower-fixed.zip"
proxy_url=http://192.168.30.118:7890

if [[ ! -x "$gradle_bin" ]]; then
  echo "Missing Gradle: $gradle_bin" >&2
  exit 1
fi
if [[ ! -d /usr/lib/jvm/java-17-openjdk-amd64 ]]; then
  echo "Missing Java 17: /usr/lib/jvm/java-17-openjdk-amd64" >&2
  exit 1
fi

mkdir -p "$(dirname "$fernflower_zip")"
if [[ ! -s "$fernflower_zip" ]]; then
  curl --fail --location --proxy "$proxy_url" --retry 3 \
    'https://files.minecraftforge.net/fernflower-fix-1.0.zip' \
    --output "$fernflower_zip"
fi

init_script="$(mktemp /tmp/mekasuit-build.XXXXXX.gradle)"
trap 'rm -f "$init_script"' EXIT
cat > "$init_script" <<'GRADLE'
settingsEvaluated { settings ->
    settings.pluginManagement.repositories.maven { url = uri('/opt/minecraft-tools/maven-repo') }
}
gradle.afterProject { project ->
    project.tasks.withType(org.gradle.api.tasks.compile.JavaCompile).configureEach {
        def language = name == 'compilePatchedMcJava' ? 8 : 17
        javaCompiler.set(project.javaToolchains.compilerFor {
            languageVersion.set(org.gradle.jvm.toolchain.JavaLanguageVersion.of(language))
        })
    }
}
GRADLE

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"
export GRADLE_USER_HOME="$gradle_home"

cd "$repo_root"
exec "$gradle_bin" build --offline --init-script "$init_script" "$@"
