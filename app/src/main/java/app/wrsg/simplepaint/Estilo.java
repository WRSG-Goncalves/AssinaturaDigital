package app.wrsg.simplepaint;

import android.graphics.Color;
import android.graphics.Paint;

public class Estilo {
    public static Paint getEstiloParaLinha(){
        Paint estiloLinha = new Paint();
        estiloLinha.setAntiAlias(true);
        estiloLinha.setColor(Color.BLUE);
        estiloLinha.setStyle(Paint.Style.STROKE);
        estiloLinha.setStrokeWidth(4f);
        estiloLinha.setStrokeJoin(Paint.Join.ROUND);

        return estiloLinha;
    }
}
