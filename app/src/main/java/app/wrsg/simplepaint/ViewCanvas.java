package app.wrsg.simplepaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class ViewCanvas extends View {

    private Path mPath;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private float mEixoX, mEixoY;
    private int Tolerancia_Movimento = 5;
    private Linha mLinha;


    public ViewCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inicializaObjetos();
    }


    private void inicializaObjetos() {
        mPath = new Path();
        mLinha = new Linha(mPath);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        try {
            mLinha.desenhaLinha(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    private void inicioDoToque(float x, float y) {

        try {
            mPath.moveTo(x, y);
            mEixoX = x;
            mEixoY = y;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void moveuDedoNaTela(float x, float y) {

        float distanciaX = Math.abs(x - mEixoX);
        float distanciaY = Math.abs(y - mEixoY);

        if (distanciaX >= Tolerancia_Movimento || distanciaY >= Tolerancia_Movimento) {
            mPath.quadTo(mEixoX, mEixoY, (x + mEixoX) / 2, (y + mEixoY) / 2);
        }
        mEixoX = x;
        mEixoY = y;
    }

    private void tirouDedoDaTela() {
        mPath.lineTo(mEixoX, mEixoY);
    }

    public void limparTela() {
        mPath.reset();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                inicioDoToque(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveuDedoNaTela(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                tirouDedoDaTela();
                invalidate();
                break;
        }
        return true;
    }
}
