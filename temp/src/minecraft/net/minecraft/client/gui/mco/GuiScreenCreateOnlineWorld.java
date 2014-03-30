package net.minecraft.client.gui.mco;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenLongRunningTask;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.TaskLongRunning;
import net.minecraft.client.gui.mco.GuiScreenMcoWorldTemplate;
import net.minecraft.client.gui.mco.ScreenWithCallback;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.WorldTemplate;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class GuiScreenCreateOnlineWorld extends ScreenWithCallback {

   private static final Logger field_146765_a = LogManager.getLogger();
   private GuiScreen field_146758_f;
   private GuiTextField field_146760_g;
   private String field_146766_h;
   private static int field_146767_i = 0;
   private static int field_146764_r = 1;
   private static int field_146763_s = 2;
   private boolean field_146762_t;
   private String field_146761_u = "You must enter a name!";
   private WorldTemplate field_146759_v;
   private static final String __OBFID = "CL_00000776";


   public GuiScreenCreateOnlineWorld(GuiScreen p_i1107_1_) {
      super.field_146292_n = Collections.synchronizedList(new ArrayList());
      this.field_146758_f = p_i1107_1_;
   }

   public void func_73876_c() {
      this.field_146760_g.func_146178_a();
      this.field_146766_h = this.field_146760_g.func_146179_b();
   }

   public void func_73866_w_() {
      Keyboard.enableRepeatEvents(true);
      this.field_146292_n.clear();
      this.field_146292_n.add(new GuiButton(field_146767_i, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120 + 17, 97, 20, I18n.func_135052_a("mco.create.world", new Object[0])));
      this.field_146292_n.add(new GuiButton(field_146764_r, this.field_146294_l / 2 + 5, this.field_146295_m / 4 + 120 + 17, 95, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
      this.field_146760_g = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 100, 65, 200, 20);
      this.field_146760_g.func_146195_b(true);
      if(this.field_146766_h != null) {
         this.field_146760_g.func_146180_a(this.field_146766_h);
      }

      if(this.field_146759_v == null) {
         this.field_146292_n.add(new GuiButton(field_146763_s, this.field_146294_l / 2 - 100, 107, 200, 20, I18n.func_135052_a("mco.template.default.name", new Object[0])));
      } else {
         this.field_146292_n.add(new GuiButton(field_146763_s, this.field_146294_l / 2 - 100, 107, 200, 20, I18n.func_135052_a("mco.template.name", new Object[0]) + ": " + this.field_146759_v.field_148785_b));
      }

   }

   public void func_146281_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_146284_a(GuiButton p_146284_1_) {
      if(p_146284_1_.field_146124_l) {
         if(p_146284_1_.field_146127_k == field_146764_r) {
            this.field_146297_k.func_147108_a(this.field_146758_f);
         } else if(p_146284_1_.field_146127_k == field_146767_i) {
            this.func_146757_h();
         } else if(p_146284_1_.field_146127_k == field_146763_s) {
            this.field_146297_k.func_147108_a(new GuiScreenMcoWorldTemplate(this, this.field_146759_v));
         }

      }
   }

   private void func_146757_h() {
      if(this.func_146753_i()) {
         GuiScreenCreateOnlineWorld.TaskWorldCreation var1 = new GuiScreenCreateOnlineWorld.TaskWorldCreation(this.field_146760_g.func_146179_b(), this.field_146759_v);
         GuiScreenLongRunningTask var2 = new GuiScreenLongRunningTask(this.field_146297_k, this.field_146758_f, var1);
         var2.func_146902_g();
         this.field_146297_k.func_147108_a(var2);
      }

   }

   private boolean func_146753_i() {
      this.field_146762_t = this.field_146760_g.func_146179_b() == null || this.field_146760_g.func_146179_b().trim().equals("");
      return !this.field_146762_t;
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_146760_g.func_146201_a(p_73869_1_, p_73869_2_);
      if(p_73869_2_ == 15) {
         this.field_146760_g.func_146195_b(!this.field_146760_g.func_146206_l());
      }

      if(p_73869_2_ == 28 || p_73869_2_ == 156) {
         this.func_146284_a((GuiButton)this.field_146292_n.get(0));
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      this.field_146760_g.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146276_q_();
      this.func_73732_a(this.field_146289_q, I18n.func_135052_a("mco.selectServer.create", new Object[0]), this.field_146294_l / 2, 11, 16777215);
      this.func_73731_b(this.field_146289_q, I18n.func_135052_a("mco.configure.world.name", new Object[0]), this.field_146294_l / 2 - 100, 52, 10526880);
      if(this.field_146762_t) {
         this.func_73732_a(this.field_146289_q, this.field_146761_u, this.field_146294_l / 2, 167, 16711680);
      }

      this.field_146760_g.func_146194_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_146735_a(WorldTemplate p_146756_1_) {
      this.field_146759_v = p_146756_1_;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_146735_a(Object p_146735_1_) {
      this.func_146735_a((WorldTemplate)p_146735_1_);
   }


   class TaskWorldCreation extends TaskLongRunning {

      private final String field_148427_c;
      private final WorldTemplate field_148426_d;
      private static final String __OBFID = "CL_00000777";


      public TaskWorldCreation(String p_i45036_2_, WorldTemplate p_i45036_3_) {
         this.field_148427_c = p_i45036_2_;
         this.field_148426_d = p_i45036_3_;
      }

      public void run() {
         String var1 = I18n.func_135052_a("mco.create.world.wait", new Object[0]);
         this.func_148417_b(var1);
         Session var2 = GuiScreenCreateOnlineWorld.this.field_146297_k.func_110432_I();
         McoClient var3 = new McoClient(var2.func_111286_b(), var2.func_111285_a(), "1.7.2", Minecraft.func_71410_x().func_110437_J());

         try {
            if(this.field_148426_d != null) {
               var3.func_148707_a(this.field_148427_c, this.field_148426_d.field_148787_a);
            } else {
               var3.func_148707_a(this.field_148427_c, "-1");
            }

            GuiScreenCreateOnlineWorld.this.field_146297_k.func_147108_a(GuiScreenCreateOnlineWorld.this.field_146758_f);
         } catch (ExceptionMcoService var5) {
            GuiScreenCreateOnlineWorld.field_146765_a.error("Couldn\'t create world");
            this.func_148416_a(var5.toString());
         } catch (UnsupportedEncodingException var6) {
            GuiScreenCreateOnlineWorld.field_146765_a.error("Couldn\'t create world");
            this.func_148416_a(var6.getLocalizedMessage());
         } catch (IOException var7) {
            GuiScreenCreateOnlineWorld.field_146765_a.error("Could not parse response creating world");
            this.func_148416_a(var7.getLocalizedMessage());
         } catch (Exception var8) {
            GuiScreenCreateOnlineWorld.field_146765_a.error("Could not create world");
            this.func_148416_a(var8.getLocalizedMessage());
         }

      }
   }
}
