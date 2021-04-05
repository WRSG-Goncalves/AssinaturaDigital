package app.wrsg.simplepaint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Linha {
    private Path mPath;
    private static Paint paint = Estilo.getEstiloParaLinha();

    public Linha(Path path) {
        this.mPath = path;

    }

    public void desenhaLinha(Canvas canvas) {

        try {
            canvas.drawPath(mPath, paint);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
