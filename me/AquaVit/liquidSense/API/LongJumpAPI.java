package me.AquaVit.liquidSense.API;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import net.ccbluex.liquidbounce.event.MoveEvent;
import net.minecraft.client.Minecraft;

public class LongJumpAPI {
   // $FF: synthetic field
   private static final int[] lllIIIIlII;
   // $FF: synthetic field
   private static final Minecraft mc;

   private static native int llIIIIlllIlI(double var0, double var2);

   public static native double getJumpBoostModifier(double var0);

   private static native boolean llIIIIllllII(int var0);

   public static native void setSpeed(MoveEvent var0, double var1, float var3, double var4, double var6);

   public static native double getBaseMoveSpeed();

   private static native boolean llIIIIlllIll(int var0);

   private static native void llIIIIlllIII();

   private static native boolean llIIIIllllIl(int var0);

   static native void $jnicClinit();

   public static native void setSpeed(MoveEvent var0, double var1);

   private static native int llIIIIlllIIl(double var0, double var2);

   static {
      boolean var0 = System.getProperty("os.arch").contains("64");
      String var1 = System.getProperty("os.name").toLowerCase();
      String var2 = null;
      if (var1.contains("win") && var0) {
         var2 = "/dev/jnic/lib/27bdb31f-577b-47c7-b0e0-ab4558184217.dat";
      }

      if (var2 == null) {
         throw new RuntimeException("Failed to load");
      } else {
         File var3;
         try {
            var3 = File.createTempFile("lib", (String)null);
            var3.deleteOnExit();
            if (!var3.exists()) {
               throw new IOException();
            }
         } catch (IOException var40) {
            throw new UnsatisfiedLinkError("Failed to create temp file");
         }

         byte[] var4 = new byte[2048];

         try {
            InputStream var5 = LongJumpAPI.class.getResourceAsStream(var2);
            Throwable var6 = null;

            try {
               FileOutputStream var7 = new FileOutputStream(var3);
               Throwable var8 = null;

               try {
                  int var9;
                  try {
                     while((var9 = var5.read(var4)) != -1) {
                        var7.write(var4, 0, var9);
                     }
                  } catch (Throwable var35) {
                     var8 = var35;
                     throw var35;
                  }
               } finally {
                  if (var7 != null) {
                     if (var8 != null) {
                        try {
                           var7.close();
                        } catch (Throwable var34) {
                           var8.addSuppressed(var34);
                        }
                     } else {
                        var7.close();
                     }
                  }

               }
            } catch (Throwable var37) {
               var6 = var37;
               throw var37;
            } finally {
               if (var5 != null) {
                  if (var6 != null) {
                     try {
                        var5.close();
                     } catch (Throwable var33) {
                        var6.addSuppressed(var33);
                     }
                  } else {
                     var5.close();
                  }
               }

            }
         } catch (IOException var39) {
            throw new UnsatisfiedLinkError("Failed to copy file: " + var39.getMessage());
         }

         System.load(var3.getAbsolutePath());
         $jnicClinit();
      }
   }
}
