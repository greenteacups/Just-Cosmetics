package cosmetics;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.function.Supplier;

public enum ParticleType {
    COMPOSTER("Composter Particle", "VINE", 30, "COMPOSTER"),
    ANGRY_VILLAGER("Angry Villager Particle", "FIREWORK_STAR", 30, "VILLAGER_ANGRY"),
    ASH("Ash Particle", "BASALT", 30, "ASH"),
    WATER_BUBBLE("Water Bubble Particle", "TUBE_CORAL_FAN", 30, "WATER_BUBBLE"),
    BUBBLE_POP("Bubble Pop Particle", "TUBE_CORAL", 30, "BUBBLE_POP"),
    SMOULDER("Smoulder Particle", "FIRE_CHARGE", 30, "SMOKE_NORMAL"),
    SMOKE("Smoke Particle", "MAGMA_CREAM", 30, "SMOKE_LARGE"),
    CAMPFIRE_SMOKE("Campfire Smoke Particle", "CAMPFIRE", 30, "CAMPFIRE_COSY_SMOKE"),
    CLOUD("Cloud Particle", "COBWEB", 30, "CLOUD"),
    CRIMSOM_SPORE("Crimson Spore Particle", "CRIMSON_FUNGUS", 30, "CRIMSON_SPORE"),
    WARPED_SPORE("Warped Spore Particle", "WARPED_FUNGUS", 30, "WARPED_SPORE"),
    CRITICAL_HIT("Critical Hit Particle", "TIPPED_ARROW", 30, "CRIT"),
    DAMAGE_INDICATOR("Damage Particle", "POPPY", 30, "DAMAGE_INDICATOR"),
    DRAGON_BREATH("Dragon Breath Particle", "DRAGON_HEAD", 30, "DRAGON_BREATH"),
    HONEY_DROPS("Honey Drops Particle", "BEE_NEST", 30, "FALLING_HONEY"),
    WATER_DROPS("Water Drops Particle", "WATER_BUCKET", 30, "DRIP_WATER"),
    LAVA_DROPS("Lava Drops Particle", "LAVA_BUCKET", 30, "DRIP_LAVA"),
    OBSIDIAN_TEARS("Obsidian Tears Particle", "CRYING_OBSIDIAN", 30, "FALLING_OBSIDIAN_TEAR"),
    WHITE_SPELL("White Spell Particle", "WHITE_DYE", 30, "SPELL"),
    BLACK_SPELL("Black Spell Particle", "BLACK_DYE", 30, "SPELL_MOB", (Supplier<Color>) () -> Color.fromRGB((int) (Math.random() * 0x1000000))),
    PURPLE_SPELL("Purple Spell Particle", "PURPLE_DYE", 30, "SPELL_WITCH"),
    ENCHANT_GLYPH("Enchant Glyph Particle", "ENCHANTING_TABLE", 30, "ENCHANTMENT_TABLE"),
    END_ROD("End Rod Particle", "END_ROD", 30, "END_ROD"),
    TOTEM("Totem Particle", "TOTEM_OF_UNDYING", 30, "TOTEM"),
    SOUL_FIRE("Soul Fire Particle", "SOUL_TORCH", 30, "SOUL_FIRE_FLAME"),
    NECTAR("Nectar Particle", "DANDELION", 30, "FALLING_NECTAR"),
    WATER_WAKE("Water Wake Particle", "FISHING_ROD", 30, "WATER_WAKE"),
    HEART("Heart Particle", "CAKE", 30, "HEART"),
    SLIME("Slime Particle", "SLIME_BALL", 30, "SLIME"),
    SNOWBALL("Snowball Particle", "SNOWBALL", 30, "SNOWBALL"),
    NAUTILUS("Nautilus Particle", "NAUTILUS_SHELL", 30, "NAUTILUS"),
    MUSIC_NOTE("Music Note Particle", "NOTE_BLOCK", 30, "NOTE"),
    CONTAGIOUS("Contagious Particle", "BAMBOO", 30, "SNEEZE"),
    INK("Ink Particle", "INK_SAC", 30, "SQUID_INK"),
    FLAME("Flame Particle", "TORCH", 30, "FLAME"),
    GLOW_SQUID("Glow Squid Particle", "GLOW_INK_SAC", 30, "GLOW"),
    CHERRY_LEAVES("Cherry Leaves Particle", "CHERRY_LEAVES", 30, "CHERRY_LEAVES"),
    TRIAL_OMEN("Trial Omen Particle", "OMINOUS_TRIAL_KEY", 30, "TRIAL_OMEN"),
    ;

    private final String title;
    private final Material material;
    private final int price;
    private final Particle particle;
    private final Object[] data;

    ParticleType(String title, String material, int price, String particle, Object... data) {
        this(title, new String[] { material }, price, new String[] { particle }, data);
    }

    ParticleType(String title, String[] materials, int price, String particle, Object... data) {
        this(title, materials, price, new String[] { particle }, data);
    }

    ParticleType(String title, String material, int price, String[] particles, Object... data) {
        this(title, new String[] { material }, price, particles, data);
    }

    ParticleType(String title, String[] materials, int price, String[] particles, Object[] data) {
        this.title = title;
        this.material = getMaterial(materials);
        this.price = price;
        this.particle = getParticle(particles);
        this.data = data;

        if (this.particle != null && this.particle.getDataType() != Void.class && this.data.length == 0) {
            Cosmetics.cosmetics.getLogger().severe("Particle " + title + " requires data of type " + this.particle.getDataType().getSimpleName() + " but none was provided.");
        }
    }

    public String title() {
        return title;
    }

    public Material material() {
        return material;
    }

    public int price() {
        return price;
    }

    public Particle particle() {
        return particle;
    }

    public Object[] data() {
        return data;
    }

    private static Material getMaterial(String[] materials) {
        for (String material : materials) {
            try {
                return Material.valueOf(material);
            } catch (IllegalArgumentException e) {
                // Ignore
            }
        }
        Cosmetics.cosmetics.getLogger().severe("Could not find material for: " + Arrays.toString(materials));
        return Material.BARRIER;
    }

    private static Particle getParticle(String[] particles) {
        for (String particle : particles) {
            try {
                return Particle.valueOf(particle);
            } catch (IllegalArgumentException e) {
                // Ignore
            }
        }
        Cosmetics.cosmetics.getLogger().severe("Could not find particle for: " + Arrays.toString(particles));
        return null;
    }
}
