package moremekasuitmodules.common.content.gear.mekanism.mekatool;

import mekanism.api.annotations.ParametersAreNotNullByDefault;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IModule;
import mekanism.api.gear.config.IModuleConfigItem;
import mekanism.api.gear.config.ModuleConfigItemCreator;
import mekanism.api.gear.config.ModuleEnumData;
import mekanism.api.text.IHasTextComponent;
import mekanism.api.text.TextComponentGroup;
import moremekasuitmodules.common.config.MoreModulesConfig;
import moremekasuitmodules.common.content.gear.mekanism.mekasuit.gmut.MoreMekaSuitModulesLang;
import net.minecraft.util.text.ITextComponent;

@ParametersAreNotNullByDefault
public class ModuleLootingAmplificationUnit implements ICustomModule<ModuleLootingAmplificationUnit> {

    private IModuleConfigItem<LootingLevel> lootingLevel;

    public static int getMaxModules() {
        return MoreModulesConfig.current().config.mekaToolLootingAmplificationMaxModules.val();
    }

    @Override
    public void init(IModule<ModuleLootingAmplificationUnit> module, ModuleConfigItemCreator configItemCreator) {
        int unlockedLevels = LootingLevel.getUnlockedLevelCount(module.getInstalledCount());
        lootingLevel = configItemCreator.createConfigItem("looting_level", MoreMekaSuitModulesLang.MODULE_LOOTING_LEVEL,
                new ModuleEnumData<>(LootingLevel.values()[unlockedLevels - 1], unlockedLevels));
    }

    public int getEffectiveLevel(int installedCount) {
        return Math.min(Math.min(installedCount, getMaxModules()), lootingLevel.get().getLevel());
    }

    public enum LootingLevel implements IHasTextComponent {
        LOW(2),
        NORMAL(4),
        MEDIUM(6),
        HIGH(8),
        ULTRA(10);

        private final int level;
        private final ITextComponent label;

        LootingLevel(int level) {
            this.level = level;
            this.label = new TextComponentGroup().getString(Integer.toString(level));
        }

        @Override
        public ITextComponent getTextComponent() {
            return label;
        }

        public int getLevel() {
            return level;
        }

        public static int getUnlockedLevelCount(int installedCount) {
            return Math.max(1, Math.min(values().length, (Math.max(1, installedCount) + 1) / 2));
        }
    }
}
