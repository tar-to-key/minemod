package net.minecraft.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class ChatStyle {

   private ChatStyle field_150249_a;
   private EnumChatFormatting field_150247_b;
   private Boolean field_150248_c;
   private Boolean field_150245_d;
   private Boolean field_150246_e;
   private Boolean field_150243_f;
   private Boolean field_150244_g;
   private ClickEvent field_150251_h;
   private HoverEvent field_150252_i;
   private static final ChatStyle field_150250_j = new ChatStyle() {

      private static final String __OBFID = "CL_00001267";

      public EnumChatFormatting func_150215_a() {
         return null;
      }
      public boolean func_150223_b() {
         return false;
      }
      public boolean func_150242_c() {
         return false;
      }
      public boolean func_150236_d() {
         return false;
      }
      public boolean func_150234_e() {
         return false;
      }
      public boolean func_150233_f() {
         return false;
      }
      public ClickEvent func_150235_h() {
         return null;
      }
      public HoverEvent func_150210_i() {
         return null;
      }
      public ChatStyle func_150238_a(EnumChatFormatting p_150238_1_) {
         throw new UnsupportedOperationException();
      }
      public ChatStyle func_150227_a(Boolean p_150227_1_) {
         throw new UnsupportedOperationException();
      }
      public ChatStyle func_150217_b(Boolean p_150217_1_) {
         throw new UnsupportedOperationException();
      }
      public ChatStyle func_150225_c(Boolean p_150225_1_) {
         throw new UnsupportedOperationException();
      }
      public ChatStyle func_150228_d(Boolean p_150228_1_) {
         throw new UnsupportedOperationException();
      }
      public ChatStyle func_150237_e(Boolean p_150237_1_) {
         throw new UnsupportedOperationException();
      }
      public ChatStyle func_150241_a(ClickEvent p_150241_1_) {
         throw new UnsupportedOperationException();
      }
      public ChatStyle func_150209_a(HoverEvent p_150209_1_) {
         throw new UnsupportedOperationException();
      }
      public ChatStyle func_150221_a(ChatStyle p_150221_1_) {
         throw new UnsupportedOperationException();
      }
      public String toString() {
         return "Style.ROOT";
      }
      public ChatStyle func_150232_l() {
         return this;
      }
      public ChatStyle func_150206_m() {
         return this;
      }
   };
   private static final String __OBFID = "CL_00001266";


   public EnumChatFormatting func_150215_a() {
      return this.field_150247_b == null?this.func_150224_n().func_150215_a():this.field_150247_b;
   }

   public boolean func_150223_b() {
      return this.field_150248_c == null?this.func_150224_n().func_150223_b():this.field_150248_c.booleanValue();
   }

   public boolean func_150242_c() {
      return this.field_150245_d == null?this.func_150224_n().func_150242_c():this.field_150245_d.booleanValue();
   }

   public boolean func_150236_d() {
      return this.field_150243_f == null?this.func_150224_n().func_150236_d():this.field_150243_f.booleanValue();
   }

   public boolean func_150234_e() {
      return this.field_150246_e == null?this.func_150224_n().func_150234_e():this.field_150246_e.booleanValue();
   }

   public boolean func_150233_f() {
      return this.field_150244_g == null?this.func_150224_n().func_150233_f():this.field_150244_g.booleanValue();
   }

   public boolean func_150229_g() {
      return this.field_150248_c == null && this.field_150245_d == null && this.field_150243_f == null && this.field_150246_e == null && this.field_150244_g == null && this.field_150247_b == null && this.field_150251_h == null && this.field_150252_i == null;
   }

   public ClickEvent func_150235_h() {
      return this.field_150251_h == null?this.func_150224_n().func_150235_h():this.field_150251_h;
   }

   public HoverEvent func_150210_i() {
      return this.field_150252_i == null?this.func_150224_n().func_150210_i():this.field_150252_i;
   }

   public ChatStyle func_150238_a(EnumChatFormatting p_150238_1_) {
      this.field_150247_b = p_150238_1_;
      return this;
   }

   public ChatStyle func_150227_a(Boolean p_150227_1_) {
      this.field_150248_c = p_150227_1_;
      return this;
   }

   public ChatStyle func_150217_b(Boolean p_150217_1_) {
      this.field_150245_d = p_150217_1_;
      return this;
   }

   public ChatStyle func_150225_c(Boolean p_150225_1_) {
      this.field_150243_f = p_150225_1_;
      return this;
   }

   public ChatStyle func_150228_d(Boolean p_150228_1_) {
      this.field_150246_e = p_150228_1_;
      return this;
   }

   public ChatStyle func_150237_e(Boolean p_150237_1_) {
      this.field_150244_g = p_150237_1_;
      return this;
   }

   public ChatStyle func_150241_a(ClickEvent p_150241_1_) {
      this.field_150251_h = p_150241_1_;
      return this;
   }

   public ChatStyle func_150209_a(HoverEvent p_150209_1_) {
      this.field_150252_i = p_150209_1_;
      return this;
   }

   public ChatStyle func_150221_a(ChatStyle p_150221_1_) {
      this.field_150249_a = p_150221_1_;
      return this;
   }

   private ChatStyle func_150224_n() {
      return this.field_150249_a == null?field_150250_j:this.field_150249_a;
   }

   public String toString() {
      return "Style{hasParent=" + (this.field_150249_a != null) + ", color=" + this.field_150247_b + ", bold=" + this.field_150248_c + ", italic=" + this.field_150245_d + ", underlined=" + this.field_150246_e + ", obfuscated=" + this.field_150244_g + ", clickEvent=" + this.func_150235_h() + ", hoverEvent=" + this.func_150210_i() + '}';
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(!(p_equals_1_ instanceof ChatStyle)) {
         return false;
      } else {
         ChatStyle var2 = (ChatStyle)p_equals_1_;
         boolean var10000;
         if(this.func_150223_b() == var2.func_150223_b() && this.func_150215_a() == var2.func_150215_a() && this.func_150242_c() == var2.func_150242_c() && this.func_150233_f() == var2.func_150233_f() && this.func_150236_d() == var2.func_150236_d() && this.func_150234_e() == var2.func_150234_e()) {
            label56: {
               if(this.func_150235_h() != null) {
                  if(!this.func_150235_h().equals(var2.func_150235_h())) {
                     break label56;
                  }
               } else if(var2.func_150235_h() != null) {
                  break label56;
               }

               if(this.func_150210_i() != null) {
                  if(!this.func_150210_i().equals(var2.func_150210_i())) {
                     break label56;
                  }
               } else if(var2.func_150210_i() != null) {
                  break label56;
               }

               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }
   }

   public int hashCode() {
      int var1 = this.field_150247_b.hashCode();
      var1 = 31 * var1 + this.field_150248_c.hashCode();
      var1 = 31 * var1 + this.field_150245_d.hashCode();
      var1 = 31 * var1 + this.field_150246_e.hashCode();
      var1 = 31 * var1 + this.field_150243_f.hashCode();
      var1 = 31 * var1 + this.field_150244_g.hashCode();
      var1 = 31 * var1 + this.field_150251_h.hashCode();
      var1 = 31 * var1 + this.field_150252_i.hashCode();
      return var1;
   }

   public ChatStyle func_150232_l() {
      ChatStyle var1 = new ChatStyle();
      var1.field_150248_c = this.field_150248_c;
      var1.field_150245_d = this.field_150245_d;
      var1.field_150243_f = this.field_150243_f;
      var1.field_150246_e = this.field_150246_e;
      var1.field_150244_g = this.field_150244_g;
      var1.field_150247_b = this.field_150247_b;
      var1.field_150251_h = this.field_150251_h;
      var1.field_150252_i = this.field_150252_i;
      var1.field_150249_a = this.field_150249_a;
      return var1;
   }

   public ChatStyle func_150206_m() {
      ChatStyle var1 = new ChatStyle();
      var1.func_150227_a(Boolean.valueOf(this.func_150223_b()));
      var1.func_150217_b(Boolean.valueOf(this.func_150242_c()));
      var1.func_150225_c(Boolean.valueOf(this.func_150236_d()));
      var1.func_150228_d(Boolean.valueOf(this.func_150234_e()));
      var1.func_150237_e(Boolean.valueOf(this.func_150233_f()));
      var1.func_150238_a(this.func_150215_a());
      var1.func_150241_a(this.func_150235_h());
      var1.func_150209_a(this.func_150210_i());
      return var1;
   }


   public static class Serializer implements JsonDeserializer, JsonSerializer {

      private static final String __OBFID = "CL_00001268";


      public ChatStyle deserialize(JsonElement p_150204_1_, Type p_150204_2_, JsonDeserializationContext p_150204_3_) {
         if(p_150204_1_.isJsonObject()) {
            ChatStyle var4 = new ChatStyle();
            JsonObject var5 = p_150204_1_.getAsJsonObject();
            if(var5.has("bold")) {
               var4.field_150248_c = Boolean.valueOf(var5.get("bold").getAsBoolean());
            }

            if(var5.has("italic")) {
               var4.field_150245_d = Boolean.valueOf(var5.get("italic").getAsBoolean());
            }

            if(var5.has("underlined")) {
               var4.field_150246_e = Boolean.valueOf(var5.get("underlined").getAsBoolean());
            }

            if(var5.has("strikethrough")) {
               var4.field_150243_f = Boolean.valueOf(var5.get("strikethrough").getAsBoolean());
            }

            if(var5.has("obfuscated")) {
               var4.field_150244_g = Boolean.valueOf(var5.get("obfuscated").getAsBoolean());
            }

            if(var5.has("color")) {
               var4.field_150247_b = (EnumChatFormatting)p_150204_3_.deserialize(var5.get("color"), EnumChatFormatting.class);
            }

            JsonObject var6;
            if(var5.has("clickEvent")) {
               var6 = var5.getAsJsonObject("clickEvent");
               ClickEvent.Action var7 = ClickEvent.Action.func_150672_a(var6.getAsJsonPrimitive("action").getAsString());
               String var8 = var6.getAsJsonPrimitive("value").getAsString();
               if(var7 != null && var8 != null && var7.func_150674_a()) {
                  var4.field_150251_h = new ClickEvent(var7, var8);
               }
            }

            if(var5.has("hoverEvent")) {
               var6 = var5.getAsJsonObject("hoverEvent");
               HoverEvent.Action var9 = HoverEvent.Action.func_150684_a(var6.getAsJsonPrimitive("action").getAsString());
               IChatComponent var10 = (IChatComponent)p_150204_3_.deserialize(var6.get("value"), IChatComponent.class);
               if(var9 != null && var10 != null && var9.func_150686_a()) {
                  var4.field_150252_i = new HoverEvent(var9, var10);
               }
            }

            return var4;
         } else {
            return null;
         }
      }

      public JsonElement serialize(ChatStyle p_150203_1_, Type p_150203_2_, JsonSerializationContext p_150203_3_) {
         if(p_150203_1_.func_150229_g()) {
            return null;
         } else {
            JsonObject var4 = new JsonObject();
            if(p_150203_1_.field_150248_c != null) {
               var4.addProperty("bold", p_150203_1_.field_150248_c);
            }

            if(p_150203_1_.field_150245_d != null) {
               var4.addProperty("italic", p_150203_1_.field_150245_d);
            }

            if(p_150203_1_.field_150246_e != null) {
               var4.addProperty("underlined", p_150203_1_.field_150246_e);
            }

            if(p_150203_1_.field_150243_f != null) {
               var4.addProperty("strikethrough", p_150203_1_.field_150243_f);
            }

            if(p_150203_1_.field_150244_g != null) {
               var4.addProperty("obfuscated", p_150203_1_.field_150244_g);
            }

            if(p_150203_1_.field_150247_b != null) {
               var4.add("color", p_150203_3_.serialize(p_150203_1_.field_150247_b));
            }

            JsonObject var5;
            if(p_150203_1_.field_150251_h != null) {
               var5 = new JsonObject();
               var5.addProperty("action", p_150203_1_.field_150251_h.func_150669_a().func_150673_b());
               var5.addProperty("value", p_150203_1_.field_150251_h.func_150668_b());
               var4.add("clickEvent", var5);
            }

            if(p_150203_1_.field_150252_i != null) {
               var5 = new JsonObject();
               var5.addProperty("action", p_150203_1_.field_150252_i.func_150701_a().func_150685_b());
               var5.add("value", p_150203_3_.serialize(p_150203_1_.field_150252_i.func_150702_b()));
               var4.add("hoverEvent", var5);
            }

            return var4;
         }
      }

      // $FF: synthetic method
      public JsonElement serialize(Object p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
         return this.serialize((ChatStyle)p_serialize_1_, p_serialize_2_, p_serialize_3_);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
         return this.deserialize(p_deserialize_1_, p_deserialize_2_, p_deserialize_3_);
      }
   }
}
