package net.moddingplayground.twigs.crafting.conditions;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;
import net.moddingplayground.twigs.Twigs;

public class QuarkCondition implements ICondition {

    private final ResourceLocation resourceLocation;
    private final String flag;

    public QuarkCondition(ResourceLocation resourceLocation, String flag) {
        this.resourceLocation = resourceLocation;
        this.flag = flag;
    }

    @Override
    public ResourceLocation getID() {
        return this.resourceLocation;
    }

    @Override
    public boolean test(IContext context) {
        if (ModList.get().isLoaded("quark")) {
            JsonObject dummy = new JsonObject();
            dummy.addProperty("type", "quark:flag");
            dummy.addProperty("flag", this.flag);
            return CraftingHelper.getCondition(dummy).test(context);
        } else {
            return false;
        }
    }

    public static class Serializer implements IConditionSerializer<QuarkCondition> {
        private final ResourceLocation resourceLocation;

        public Serializer() {
            this.resourceLocation = new ResourceLocation(Twigs.MOD_ID, "quark_flag");
        }

        @Override
        public void write(JsonObject json, QuarkCondition value) {
            json.addProperty("flag", value.flag);
        }

        @Override
        public QuarkCondition read(JsonObject json) {
            return new QuarkCondition(this.resourceLocation, json.getAsJsonPrimitive("flag").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return this.resourceLocation;
        }
    }
}
