package me.AquaVit.liquidSense.API;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Particles {
   // $FF: synthetic field
   public String text;
   // $FF: synthetic field
   public int ticks;
   // $FF: synthetic field
   private static final int[] lllllIIlII;
   // $FF: synthetic field
   public Location location;

   public Particles(Location lllllllllllllllllllIIlIIIlIIIllI, String lllllllllllllllllllIIlIIIlIIlIII) {
      lllllllllllllllllllIIlIIIlIIlIlI.location = lllllllllllllllllllIIlIIIlIIIllI;
      lllllllllllllllllllIIlIIIlIIlIlI.text = lllllllllllllllllllIIlIIIlIIlIII;
      lllllllllllllllllllIIlIIIlIIlIlI.ticks = lllllIIlII[0];
   }

   private static native void llIllIIIlIlI();

   private static native boolean llIllIIIlIll(int var0);

   static native void $jnicClinit();

   public static native double roundToPlace(float var0, int var1);

   static {
      boolean var0 = System.getProperty("os.arch").contains("64");
      String var1 = System.getProperty("os.name").toLowerCase();
      String var2 = null;
      if (var1.contains("win") && var0) {
         var2 = "/dev/jnic/lib/c3741595-fc83-4cc3-b557-62e0be6ced2b.dat";
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
            InputStream var5 = Particles.class.getResourceAsStream(var2);
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
