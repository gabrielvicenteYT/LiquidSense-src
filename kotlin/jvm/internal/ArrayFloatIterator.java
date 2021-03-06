package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.FloatIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"},
   d2 = {"Lkotlin/jvm/internal/ArrayFloatIterator;", "Lkotlin/collections/FloatIterator;", "array", "", "([F)V", "index", "", "hasNext", "", "nextFloat", "", "kotlin-stdlib"}
)
final class ArrayFloatIterator extends FloatIterator {
   private int index;
   private final float[] array;

   public boolean hasNext() {
      return this.index < this.array.length;
   }

   public float nextFloat() {
      try {
         float[] var10000 = this.array;
         int var1;
         this.index = (var1 = this.index) + 1;
         float var4 = var10000[var1];
         return var4;
      } catch (ArrayIndexOutOfBoundsException var3) {
         --this.index;
         throw (Throwable)(new NoSuchElementException(var3.getMessage()));
      }
   }

   public ArrayFloatIterator(@NotNull float[] array) {
      Intrinsics.checkParameterIsNotNull(array, "array");
      super();
      this.array = array;
   }
}
