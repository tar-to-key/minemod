package net.minecraft.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumTypeAdapterFactory;

public interface IChatComponent extends Iterable {

   IChatComponent func_150255_a(ChatStyle var1);

   ChatStyle func_150256_b();

   IChatComponent func_150258_a(String var1);

   IChatComponent func_150257_a(IChatComponent var1);

   String func_150261_e();

   String func_150260_c();

   List func_150253_a();

   IChatComponent func_150259_f();

   public static class Serializer implements JsonDeserializer, JsonSerializer {

      private static final Gson field_150700_a;
      private static final String __OBFID = "CL_00001263";


      public IChatComponent deserialize(JsonElement p_150698_1_, Type p_150698_2_, JsonDeserializationContext p_150698_3_) {
         if(p_150698_1_.isJsonPrimitive()) {
            return new ChatComponentText(p_150698_1_.getAsString());
         } else if(!p_150698_1_.isJsonObject()) {
            if(p_150698_1_.isJsonArray()) {
               JsonArray var11 = p_150698_1_.getAsJsonArray();
               IChatComponent var12 = null;
               Iterator var13 = var11.iterator();

               while(var13.hasNext()) {
                  JsonElement var16 = (JsonElement)var13.next();
                  IChatComponent var17 = this.deserialize(var16, var16.getClass(), p_150698_3_);
                  if(var12 == null) {
                     var12 = var17;
                  } else {
                     var12.func_150257_a(var17);
                  }
               }

               return var12;
            } else {
               throw new JsonParseException("Don\'t know how to turn " + p_150698_1_.toString() + " into a Component");
            }
         } else {
            JsonObject var4 = p_150698_1_.getAsJsonObject();
            Object var5;
            if(var4.has("text")) {
               var5 = new ChatComponentText(var4.get("text").getAsString());
            } else {
               if(!var4.has("translate")) {
                  throw new JsonParseException("Don\'t know how to turn " + p_150698_1_.toString() + " into a Component");
               }

               String var6 = var4.get("translate").getAsString();
               if(var4.has("with")) {
                  JsonArray var7 = var4.getAsJsonArray("with");
                  Object[] var8 = new Object[var7.size()];

                  for(int var9 = 0; var9 < var8.length; ++var9) {
                     var8[var9] = this.deserialize(var7.get(var9), p_150698_2_, p_150698_3_);
                     if(var8[var9] instanceof ChatComponentText) {
                        ChatComponentText var10 = (ChatComponentText)var8[var9];
                        if(var10.func_150256_b().func_150229_g() && var10.func_150253_a().isEmpty()) {
                           var8[var9] = var10.func_150265_g();
                        }
                     }
                  }

                  var5 = new ChatComponentTranslation(var6, var8);
               } else {
                  var5 = new ChatComponentTranslation(var6, new Object[0]);
               }
            }

            if(var4.has("extra")) {
               JsonArray var14 = var4.getAsJsonArray("extra");
               if(var14.size() <= 0) {
                  throw new JsonParseException("Unexpected empty array of components");
               }

               for(int var15 = 0; var15 < var14.size(); ++var15) {
                  ((IChatComponent)var5).func_150257_a(this.deserialize(var14.get(var15), p_150698_2_, p_150698_3_));
               }
            }

            ((IChatComponent)var5).func_150255_a((ChatStyle)p_150698_3_.deserialize(p_150698_1_, ChatStyle.class));
            return (IChatComponent)var5;
         }
      }

      private void func_150695_a(ChatStyle p_150695_1_, JsonObject p_150695_2_, JsonSerializationContext p_150695_3_) {
         JsonElement var4 = p_150695_3_.serialize(p_150695_1_);
         if(var4.isJsonObject()) {
            JsonObject var5 = (JsonObject)var4;
            Iterator var6 = var5.entrySet().iterator();

            while(var6.hasNext()) {
               Entry var7 = (Entry)var6.next();
               p_150695_2_.add((String)var7.getKey(), (JsonElement)var7.getValue());
            }
         }

      }

      public JsonElement serialize(IChatComponent p_150697_1_, Type p_150697_2_, JsonSerializationContext p_150697_3_) {
         if(p_150697_1_ instanceof ChatComponentText && p_150697_1_.func_150256_b().func_150229_g() && p_150697_1_.func_150253_a().isEmpty()) {
            return new JsonPrimitive(((ChatComponentText)p_150697_1_).func_150265_g());
         } else {
            JsonObject var4 = new JsonObject();
            if(!p_150697_1_.func_150256_b().func_150229_g()) {
               this.func_150695_a(p_150697_1_.func_150256_b(), var4, p_150697_3_);
            }

            if(!p_150697_1_.func_150253_a().isEmpty()) {
               JsonArray var5 = new JsonArray();
               Iterator var6 = p_150697_1_.func_150253_a().iterator();

               while(var6.hasNext()) {
                  IChatComponent var7 = (IChatComponent)var6.next();
                  var5.add(this.serialize(var7, var7.getClass(), p_150697_3_));
               }

               var4.add("extra", var5);
            }

            if(p_150697_1_ instanceof ChatComponentText) {
               var4.addProperty("text", ((ChatComponentText)p_150697_1_).func_150265_g());
            } else {
               if(!(p_150697_1_ instanceof ChatComponentTranslation)) {
                  throw new IllegalArgumentException("Don\'t know how to serialize " + p_150697_1_ + " as a Component");
               }

               ChatComponentTranslation var11 = (ChatComponentTranslation)p_150697_1_;
               var4.addProperty("translate", var11.func_150268_i());
               if(var11.func_150271_j() != null && var11.func_150271_j().length > 0) {
                  JsonArray var12 = new JsonArray();
                  Object[] var13 = var11.func_150271_j();
                  int var8 = var13.length;

                  for(int var9 = 0; var9 < var8; ++var9) {
                     Object var10 = var13[var9];
                     if(var10 instanceof IChatComponent) {
                        var12.add(this.serialize((IChatComponent)var10, var10.getClass(), p_150697_3_));
                     } else {
                        var12.add(new JsonPrimitive(String.valueOf(var10)));
                     }
                  }

                  var4.add("with", var12);
               }
            }

            return var4;
         }
      }

      public static String func_150696_a(IChatComponent p_150696_0_) {
         return field_150700_a.toJson(p_150696_0_);
      }

      public static IChatComponent func_150699_a(String p_150699_0_) {
         return (IChatComponent)field_150700_a.fromJson(p_150699_0_, IChatComponent.class);
      }

      // $FF: synthetic method
      public JsonElement serialize(Object p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
         return this.serialize((IChatComponent)p_serialize_1_, p_serialize_2_, p_serialize_3_);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
         return this.deserialize(p_deserialize_1_, p_deserialize_2_, p_deserialize_3_);
      }

      static {
         GsonBuilder var0 = new GsonBuilder();
         var0.registerTypeHierarchyAdapter(IChatComponent.class, new IChatComponent.Serializer());
         var0.registerTypeHierarchyAdapter(ChatStyle.class, new ChatStyle.Serializer());
         var0.registerTypeAdapterFactory(new EnumTypeAdapterFactory());
         field_150700_a = var0.create();
      }
   }
}
