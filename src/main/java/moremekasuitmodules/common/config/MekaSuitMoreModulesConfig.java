package moremekasuitmodules.common.config;

import mekanism.common.config.BaseConfig;
import mekanism.common.config.options.BooleanOption;
import mekanism.common.config.options.DoubleOption;
import mekanism.common.config.options.FloatOption;
import mekanism.common.config.options.IntOption;

import java.util.LinkedHashMap;
import java.util.Map;

public class MekaSuitMoreModulesConfig extends BaseConfig {

    public BooleanOption mekaSuitShield = new BooleanOption(this, "mekaSuitShield", true, "启用整套护盾的默认计算 / Enables the default calculation of the full set of shields");
    public FloatOption mekaSuitShieldCapacity = new FloatOption(this,  "mekaSuitShieldCapacity", 1000.0F, "安装后的默认基础护盾值 / The default set of base shield values after installation", 1.0F, Float.MAX_VALUE);
    public BooleanOption mekaSuitRecovery = new BooleanOption(this,  "mekaSuitRecovery", true, "启用整套恢复的默认计算 / Enables the default calculation of the full set of recovery");
    public FloatOption mekaSuitRecoveryRate = new FloatOption(this,  "mekaSuitRecoveryRate", 10.0F, "默认安装后整套基础护盾的恢复速率 / The recovery rate of the full set of base shields after the default installation", 0.1F, Float.MAX_VALUE);
    public IntOption mekaSuitShieldRestoresEnergy = new IntOption(this,  "mekaSuitShieldRestoresEnergy", 500, "护盾每次恢复少量值所需的能量 / The amount of energy required whenever the shield recovers a little", 0, Integer.MAX_VALUE);
    public BooleanOption MekAsuitOverloadProtection = new BooleanOption(this,  "MekAsuitOverloadProtection", true, "安装紧急救援时允许 MekaSuit 拦截直接 setHealth / Allows MekaSuit to intercept direct setHealth with Emergency Rescue installed");
    public final BooleanOption DRrecipes = new BooleanOption(this,  "DRrecipes", true, "启用默认的 Draconic Evolution 配方 / Enable the default Draconic Evolution recipe").setRequiresGameRestart();
    public final BooleanOption DRAdditionsrecipes = new BooleanOption(this,  "DRAdditionsrecipes", true, "启用默认的 Draconic Additions 配方 / Enable the default Draconic Additions recipe").setRequiresGameRestart();
    public final BooleanOption InfiniteInterception = new BooleanOption(this,  "InfiniteInterception", false, "启用无限拦截救援系统单元 / Enable Infinite interception and rescue system unit").setRequiresGameRestart();
    public final BooleanOption TCRecipes = new BooleanOption(this,  "TCRecipes", true, "启用默认的 Thaumcraft 配方 / Enable the default Thaumcraft recipe");
    public final BooleanOption TCAspectRecipes = new BooleanOption(this,  "TCAspectRecipes", true, "允许默认 Thaumcraft 配方加入两类元素合成的元素 / Let default Thaumcraft recipes add synthesized elements from both types into the recipe");
    public DoubleOption mekaSuitEnergyUsageItemAttack = new DoubleOption(this, "energyUsageItemattack", 200, "攻击实体每 tick 的能量消耗 / Energy cost per tick attacking entity");
    public IntOption MekAsuitAutoAttackMax = new IntOption(this,"MekAsuitAutoAttackMax",20,"每 tick 最大攻击目标数 / Maximum attack targets per tick",1,Integer.MAX_VALUE);
    public DoubleOption mekaToolEnergyUsageLootingAmplification = new DoubleOption(this, "energyUsageLootingAmplification", 500, "每级有效抢夺等级的能量消耗 / Energy cost per effective looting level");
    public DoubleOption mekaToolEnergyUsageKnockbackControl = new DoubleOption(this, "energyUsageKnockbackControl", 250, "每点击退强度的能量消耗 / Energy cost per knockback strength");
    public DoubleOption mekaToolEnergyUsageExecution = new DoubleOption(this, "energyUsageExecution", 1000, "每个已安装处决单元的能量消耗 / Energy cost per installed execution unit");
    public DoubleOption mekaSuitEnergyUsageAutomaticExtinguish = new DoubleOption(this, "energyUsageAutomaticExtinguish", 1000, "自动灭火时的能量消耗 / Energy cost when automatic extinguish removes fire");
    public DoubleOption mekaToolEnergyUsageSmelting = new DoubleOption(this, "energyUsageSmelting", 200, "Meka 工具每熔炼一个掉落物的能量消耗 / Energy cost per smelted item dropped by Meka-Tool");
    public DoubleOption mekaSuitEnergyUsageImpactWave = new DoubleOption(this, "energyUsageImpactWave", 350, "冲击波每个半径方块的能量消耗 / Energy cost per impact wave radius block");
    public IntOption mekaSuitOxygenCapacity = new IntOption(this, "mekaSuitOxygenCapacity", 24000, "MekaSuit 头盔氧气供应单元的氧气容量 / Oxygen capacity for the MekaSuit helmet oxygen supply unit", 0, Integer.MAX_VALUE);
    public IntOption mekaSuitOxygenUsage = new IntOption(this, "mekaSuitOxygenUsage", 1, "启用氧气供应单元时每 tick 消耗的氧气 / Oxygen consumed per tick while the oxygen supply unit is enabled", 0, Integer.MAX_VALUE);

    private final Map<String, IntOption> moduleMaxModules = new LinkedHashMap<>();

    public MekaSuitMoreModulesConfig() {
        registerModuleMax("emergency_rescue_unit", 10, "复活时每次消耗1个单元；有效数量=已安装数量 / Each rescue consumes 1 unit; effective count equals installed count");
        registerModuleMax("advanced_interception_system_unit", 1, "不消耗紧急救援单元；数量仅限制安装上限 / Does not consume emergency rescue units; count only limits installation");
        registerModuleMax("seal_unit", 1, "数量仅限制安装上限；密封效果不按数量叠加 / Count only limits installation; sealing does not scale with count");
        registerModuleMax("oxygen_supply_unit", 1, "氧气容量和消耗由独立配置决定；数量仅限制安装上限 / Oxygen capacity and usage use separate settings; count only limits installation");
        registerModuleMax("thermal_protection_unit", 1, "数量仅限制安装上限；热防护为开关效果 / Count only limits installation; thermal protection is a toggle effect");
        registerModuleMax("insulated_unit", 1, "数量仅限制安装上限；绝缘为开关效果 / Count only limits installation; insulation is a toggle effect");
        registerModuleMax("bee_control_unit", 1, "数量仅限制安装上限；防蜂为开关效果 / Count only limits installation; bee protection is a toggle effect");
        registerModuleMax("warp_clear_base_unit", 1, "数量仅限制安装上限；每次清除对应扭曲值 / Count only limits installation; each use clears the corresponding warp");
        registerModuleMax("warp_clear_advanced_unit", 1, "数量仅限制安装上限；每次清除对应扭曲值 / Count only limits installation; each use clears the corresponding warp");
        registerModuleMax("warp_clear_ultimate_unit", 1, "数量仅限制安装上限；每次清除对应扭曲值 / Count only limits installation; each use clears the corresponding warp");
        registerModuleMax("magic_optimization_unit", 25, "Vis消耗减免按已安装数量计算 / Vis reduction scales with installed count");
        registerModuleMax("goggles_of_revealing_unit", 1, "数量仅限制安装上限；效果等同揭示之护目镜 / Count only limits installation; effect matches Goggles of Revealing");
        registerModuleMax("intelligent_temperature_regulation_unit", 1, "数量仅限制安装上限；保持最佳温度 / Count only limits installation; keeps the optimal temperature");
        registerModuleMax("automatic_liquid_supply_unit", 1, "数量仅限制安装上限；自动供液为开关效果 / Count only limits installation; automatic supply is a toggle effect");
        registerModuleMax("gravitational_modulating_additional_unit", 1, "数量仅限制安装上限；具体功能由模式配置决定 / Count only limits installation; behavior is controlled by mode settings");
        registerModuleMax("energy_shield_unit", 10, "护盾强度按已安装数量参与计算 / Shield strength scales with installed count");
        registerModuleMax("chaos_resistance_unit", 25, "混沌抗性=有效单元数量% / Chaos resistance equals effective unit count percent");
        registerModuleMax("percentage_damage_limit_unit", 10, "总数量<4M时伤害倍率=1-总数量/(4M)，达到4M后每次最多受1点伤害；M为每件护甲上限 / Below 4M, damage multiplier=1-total count/(4M); at 4M, each hit is limited to 1 damage; M is the per-armor cap");
        registerModuleMax("chaos_vortex_stabilization_unit", 10, "每平息1个混沌旋涡消耗1个单元 / Quelling one chaos vortex consumes one unit");
        registerModuleMax("smart_shielding_unit", 1, "数量仅限制安装上限；屏蔽目光为开关效果 / Count only limits installation; gaze shielding is a toggle effect");
        registerModuleMax("infinite_energy_supply_unit", 1, "数量仅限制安装上限；持续填充能量 / Count only limits installation; continuously fills energy");
        registerModuleMax("infinite_interception_and_rescue_system_unit", 1, "数量仅限制安装上限；无敌和拦截为开关效果 / Count only limits installation; invulnerability and interception are toggle effects");
        registerModuleMax("band_of_aura_unit", 1, "固定生成1 mana/tick；当前实现不按堆叠数量增加 / Generates 1 mana/tick; current implementation does not scale with stack count");
        registerModuleMax("basic_band_of_aura_unit", 1, "固定生成3 mana/tick；当前实现不按堆叠数量增加 / Generates 3 mana/tick; current implementation does not scale with stack count");
        registerModuleMax("advanced_band_of_aura_unit", 1, "固定生成5 mana/tick；当前实现不按堆叠数量增加 / Generates 5 mana/tick; current implementation does not scale with stack count");
        registerModuleMax("elite_band_of_aura_unit", 1, "固定生成7 mana/tick；当前实现不按堆叠数量增加 / Generates 7 mana/tick; current implementation does not scale with stack count");
        registerModuleMax("ultimate_band_of_aura_unit", 1, "固定生成9 mana/tick；当前实现不按堆叠数量增加 / Generates 9 mana/tick; current implementation does not scale with stack count");
        registerModuleMax("creative_band_of_aura_unit", 1, "每tick填满可携带魔力的物品；当前实现不按堆叠数量增加 / Fills carried mana items each tick; current implementation does not scale with stack count");
        registerModuleMax("smart_wireless_unit", 1, "数量仅限制安装上限；无线访问为开关效果 / Count only limits installation; wireless access is a toggle effect");
        registerModuleMax("infinite_gas_supply_unit", 1, "数量仅限制安装上限；持续填充气体 / Count only limits installation; continuously fills gas");
        registerModuleMax("automatic_attack_unit", 4, "安装数量解锁攻击范围和攻击间隔档位；实际目标数受独立配置限制 / Installed count unlocks attack range and interval tiers; target count uses a separate setting");
        registerModuleMax("counterattack_unit", 10, "反击伤害=入场伤害×四件护甲有效单元总数/10 / Counter damage equals incoming damage times total effective units on four armor pieces divided by 10");
        registerModuleMax("power_enhancement_unit", 64, "攻击伤害和攻击速度各增加有效单元数量 / Attack damage and attack speed each increase by effective unit count");
        registerModuleMax("high_speed_cooling_unit", 10, "每个单元每tick额外推进1次冷却 / Each unit advances cooldown by one extra tick");
        registerModuleMax("quantum_reconstruction_unit", 1, "数量仅限制安装上限；穿墙为模式开关效果 / Count only limits installation; phasing is a mode toggle effect");
        registerModuleMax("hp_boots_unit", 64, "最大生命值增加有效单元数量 / Maximum health increases by effective unit count");
        registerModuleMax("optical_camouflage_unit", 1, "数量仅限制安装上限；隐身取决于护甲部位和整套状态 / Count only limits installation; camouflage depends on armor slots and full-suit state");
        registerModuleMax("entity_display_box_unit", 1, "数量仅限制安装上限；显示参数由模块配置决定 / Count only limits installation; display parameters use module settings");
        registerModuleMax("wall_cling_unit", 1, "数量仅限制安装上限；攀附速度由模块配置决定 / Count only limits installation; climb speed uses module settings");
        registerModuleMax("ore_visual_enhancement_unit", 5, "安装数量解锁扫描范围和扫描间隔档位 / Installed count unlocks scan range and scan interval tiers");
        registerModuleMax("automatic_ore_mining_unit", 1, "每轮挖掘数量由模块的最大挖掘数量配置决定 / Blocks per cycle use the module max-blocks setting");
        registerModuleMax("looting_amplification_unit", 10, "有效抢夺等级=min(已安装数量,配置上限,选择等级) / Effective looting level=min(installed count, configured cap, selected level)");
        registerModuleMax("knockback_control_unit", 10, "击退增加=0.2×有效单元数量 / Knockback increase=0.2 times effective unit count");
        registerModuleMax("execution_unit", 10, "处决阈值=2%×有效单元数量 / Execution threshold=2% times effective unit count");
        registerModuleMax("automatic_extinguish_unit", 1, "数量仅限制安装上限；灭火每次消耗能量 / Count only limits installation; each extinguish consumes energy");
        registerModuleMax("smelting_unit", 1, "数量仅限制安装上限；熔炼每个掉落物消耗能量 / Count only limits installation; smelting each drop consumes energy");
        registerModuleMax("impact_wave_unit", 4, "冲击伤害=(落差-触发高度)×伤害倍率；数量解锁参数档位 / Impact damage=(fall distance-trigger height)×damage multiplier; count unlocks parameter tiers");
    }

    private void registerModuleMax(String moduleId, int defaultValue, String comment) {
        String key = "looting_amplification_unit".equals(moduleId) ? "maxLootingAmplificationModules" : "maxModules_" + moduleId;
        moduleMaxModules.put(moduleId, new IntOption(this, key, defaultValue, comment, 1, Integer.MAX_VALUE).setRequiresGameRestart());
    }

    public int maxModuleStackSize(String moduleId) {
        IntOption option = moduleMaxModules.get(moduleId);
        if (option == null) {
            throw new IllegalArgumentException("Unknown module max-stack setting: " + moduleId);
        }
        return option.val();
    }

    @Override
    public String getCategory() {
        return "moremodules";
    }

}
