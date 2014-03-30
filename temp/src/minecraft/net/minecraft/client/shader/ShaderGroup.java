package net.minecraft.client.shader;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.vecmath.Matrix4f;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.Shader;
import net.minecraft.client.shader.ShaderUniform;
import net.minecraft.client.util.JsonException;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class ShaderGroup {

   private final Framebuffer field_148035_a;
   private final IResourceManager field_148033_b;
   private final String field_148034_c;
   private final List field_148031_d = Lists.newArrayList();
   private final Map field_148032_e = Maps.newHashMap();
   private final List field_148029_f = Lists.newArrayList();
   private Matrix4f field_148030_g;
   private int field_148038_h;
   private int field_148039_i;
   private float field_148036_j;
   private float field_148037_k;
   private static final String __OBFID = "CL_00001041";


   public ShaderGroup(IResourceManager p_i45088_1_, Framebuffer p_i45088_2_, ResourceLocation p_i45088_3_) throws JsonException {
      this.field_148033_b = p_i45088_1_;
      this.field_148035_a = p_i45088_2_;
      this.field_148036_j = 0.0F;
      this.field_148037_k = 0.0F;
      this.field_148038_h = p_i45088_2_.field_147621_c;
      this.field_148039_i = p_i45088_2_.field_147618_d;
      this.field_148034_c = p_i45088_3_.toString();
      this.func_148024_c();
      this.func_148025_a(p_i45088_3_);
   }

   public void func_148025_a(ResourceLocation p_148025_1_) throws JsonException {
      JsonParser var2 = new JsonParser();
      InputStream var3 = null;

      try {
         IResource var4 = this.field_148033_b.func_110536_a(p_148025_1_);
         var3 = var4.func_110527_b();
         JsonObject var21 = var2.parse(IOUtils.toString(var3, Charsets.UTF_8)).getAsJsonObject();
         JsonArray var6;
         int var7;
         Iterator var8;
         JsonElement var9;
         JsonException var11;
         if(JsonUtils.func_151202_d(var21, "targets")) {
            var6 = var21.getAsJsonArray("targets");
            var7 = 0;

            for(var8 = var6.iterator(); var8.hasNext(); ++var7) {
               var9 = (JsonElement)var8.next();

               try {
                  this.func_148027_a(var9);
               } catch (Exception var18) {
                  var11 = JsonException.func_151379_a(var18);
                  var11.func_151380_a("targets[" + var7 + "]");
                  throw var11;
               }
            }
         }

         if(JsonUtils.func_151202_d(var21, "passes")) {
            var6 = var21.getAsJsonArray("passes");
            var7 = 0;

            for(var8 = var6.iterator(); var8.hasNext(); ++var7) {
               var9 = (JsonElement)var8.next();

               try {
                  this.func_148019_b(var9);
               } catch (Exception var17) {
                  var11 = JsonException.func_151379_a(var17);
                  var11.func_151380_a("passes[" + var7 + "]");
                  throw var11;
               }
            }
         }
      } catch (Exception var19) {
         JsonException var5 = JsonException.func_151379_a(var19);
         var5.func_151381_b(p_148025_1_.func_110623_a());
         throw var5;
      } finally {
         IOUtils.closeQuietly(var3);
      }

   }

   private void func_148027_a(JsonElement p_148027_1_) throws JsonException {
      if(JsonUtils.func_151211_a(p_148027_1_)) {
         this.func_148020_a(p_148027_1_.getAsString(), this.field_148038_h, this.field_148039_i);
      } else {
         JsonObject var2 = JsonUtils.func_151210_l(p_148027_1_, "target");
         String var3 = JsonUtils.func_151200_h(var2, "name");
         int var4 = JsonUtils.func_151208_a(var2, "width", this.field_148038_h);
         int var5 = JsonUtils.func_151208_a(var2, "height", this.field_148039_i);
         if(this.field_148032_e.containsKey(var3)) {
            throw new JsonException(var3 + " is already defined");
         }

         this.func_148020_a(var3, var4, var5);
      }

   }

   private void func_148019_b(JsonElement p_148019_1_) throws JsonException {
      JsonObject var2 = JsonUtils.func_151210_l(p_148019_1_, "pass");
      String var3 = JsonUtils.func_151200_h(var2, "name");
      String var4 = JsonUtils.func_151200_h(var2, "intarget");
      String var5 = JsonUtils.func_151200_h(var2, "outtarget");
      Framebuffer var6 = this.func_148017_a(var4);
      Framebuffer var7 = this.func_148017_a(var5);
      if(var6 == null) {
         throw new JsonException("Input target \'" + var4 + "\' does not exist");
      } else if(var7 == null) {
         throw new JsonException("Output target \'" + var5 + "\' does not exist");
      } else {
         Shader var8 = this.func_148023_a(var3, var6, var7);
         JsonArray var9 = JsonUtils.func_151213_a(var2, "auxtargets", (JsonArray)null);
         if(var9 != null) {
            int var10 = 0;

            for(Iterator var11 = var9.iterator(); var11.hasNext(); ++var10) {
               JsonElement var12 = (JsonElement)var11.next();

               try {
                  JsonObject var13 = JsonUtils.func_151210_l(var12, "auxtarget");
                  String var24 = JsonUtils.func_151200_h(var13, "name");
                  String var15 = JsonUtils.func_151200_h(var13, "id");
                  Framebuffer var16 = this.func_148017_a(var15);
                  if(var16 == null) {
                     throw new JsonException("Render target \'" + var15 + "\' does not exist");
                  }

                  var8.func_148041_a(var24, var16, var16.field_147622_a, var16.field_147620_b);
               } catch (Exception var18) {
                  JsonException var14 = JsonException.func_151379_a(var18);
                  var14.func_151380_a("auxtargets[" + var10 + "]");
                  throw var14;
               }
            }
         }

         JsonArray var20 = JsonUtils.func_151213_a(var2, "uniforms", (JsonArray)null);
         if(var20 != null) {
            int var19 = 0;

            for(Iterator var21 = var20.iterator(); var21.hasNext(); ++var19) {
               JsonElement var22 = (JsonElement)var21.next();

               try {
                  this.func_148028_c(var22);
               } catch (Exception var17) {
                  JsonException var23 = JsonException.func_151379_a(var17);
                  var23.func_151380_a("uniforms[" + var19 + "]");
                  throw var23;
               }
            }
         }

      }
   }

   private void func_148028_c(JsonElement p_148028_1_) throws JsonException {
      JsonObject var2 = JsonUtils.func_151210_l(p_148028_1_, "uniform");
      String var3 = JsonUtils.func_151200_h(var2, "name");
      ShaderUniform var4 = ((Shader)this.field_148031_d.get(this.field_148031_d.size() - 1)).func_148043_c().func_147991_a(var3);
      if(var4 == null) {
         throw new JsonException("Uniform \'" + var3 + "\' does not exist");
      } else {
         float[] var5 = new float[4];
         int var6 = 0;
         JsonArray var7 = JsonUtils.func_151214_t(var2, "values");

         for(Iterator var8 = var7.iterator(); var8.hasNext(); ++var6) {
            JsonElement var9 = (JsonElement)var8.next();

            try {
               var5[var6] = JsonUtils.func_151220_d(var9, "value");
            } catch (Exception var12) {
               JsonException var11 = JsonException.func_151379_a(var12);
               var11.func_151380_a("values[" + var6 + "]");
               throw var11;
            }
         }

         switch(var6) {
         case 0:
         default:
            break;
         case 1:
            var4.func_148090_a(var5[0]);
            break;
         case 2:
            var4.func_148087_a(var5[0], var5[1]);
            break;
         case 3:
            var4.func_148095_a(var5[0], var5[1], var5[2]);
            break;
         case 4:
            var4.func_148081_a(var5[0], var5[1], var5[2], var5[3]);
         }

      }
   }

   public void func_148020_a(String p_148020_1_, int p_148020_2_, int p_148020_3_) {
      Framebuffer var4 = new Framebuffer(p_148020_2_, p_148020_3_, true);
      var4.func_147604_a(0.0F, 0.0F, 0.0F, 0.0F);
      this.field_148032_e.put(p_148020_1_, var4);
      if(p_148020_2_ == this.field_148038_h && p_148020_3_ == this.field_148039_i) {
         this.field_148029_f.add(var4);
      }

   }

   public void func_148021_a() {
      Iterator var1 = this.field_148032_e.values().iterator();

      while(var1.hasNext()) {
         Framebuffer var2 = (Framebuffer)var1.next();
         var2.func_147608_a();
      }

      var1 = this.field_148031_d.iterator();

      while(var1.hasNext()) {
         Shader var3 = (Shader)var1.next();
         var3.func_148044_b();
      }

      this.field_148031_d.clear();
   }

   public Shader func_148023_a(String p_148023_1_, Framebuffer p_148023_2_, Framebuffer p_148023_3_) throws JsonException {
      Shader var4 = new Shader(this.field_148033_b, p_148023_1_, p_148023_2_, p_148023_3_);
      this.field_148031_d.add(this.field_148031_d.size(), var4);
      return var4;
   }

   private void func_148024_c() {
      this.field_148030_g = new Matrix4f();
      this.field_148030_g.setIdentity();
      this.field_148030_g.m00 = 2.0F / (float)this.field_148035_a.field_147622_a;
      this.field_148030_g.m11 = 2.0F / (float)(-this.field_148035_a.field_147620_b);
      this.field_148030_g.m22 = -0.0020001999F;
      this.field_148030_g.m33 = 1.0F;
      this.field_148030_g.m03 = -1.0F;
      this.field_148030_g.m13 = 1.0F;
      this.field_148030_g.m23 = -1.0001999F;
   }

   public void func_148026_a(int p_148026_1_, int p_148026_2_) {
      this.field_148038_h = this.field_148035_a.field_147622_a;
      this.field_148039_i = this.field_148035_a.field_147620_b;
      this.func_148024_c();
      Iterator var3 = this.field_148031_d.iterator();

      while(var3.hasNext()) {
         Shader var4 = (Shader)var3.next();
         var4.func_148045_a(this.field_148030_g);
      }

      var3 = this.field_148029_f.iterator();

      while(var3.hasNext()) {
         Framebuffer var5 = (Framebuffer)var3.next();
         var5.func_147613_a(p_148026_1_, p_148026_2_);
      }

   }

   public void func_148018_a(float p_148018_1_) {
      if(p_148018_1_ < this.field_148037_k) {
         this.field_148036_j += 1.0F - this.field_148037_k;
         this.field_148036_j += p_148018_1_;
      } else {
         this.field_148036_j += p_148018_1_ - this.field_148037_k;
      }

      for(this.field_148037_k = p_148018_1_; this.field_148036_j > 20.0F; this.field_148036_j -= 20.0F) {
         ;
      }

      Iterator var2 = this.field_148031_d.iterator();

      while(var2.hasNext()) {
         Shader var3 = (Shader)var2.next();
         var3.func_148042_a(this.field_148036_j / 20.0F);
      }

   }

   public final String func_148022_b() {
      return this.field_148034_c;
   }

   private Framebuffer func_148017_a(String p_148017_1_) {
      return p_148017_1_ == null?null:(p_148017_1_.equals("minecraft:main")?this.field_148035_a:(Framebuffer)this.field_148032_e.get(p_148017_1_));
   }
}
