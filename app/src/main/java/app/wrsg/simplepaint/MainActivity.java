package app.wrsg.simplepaint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button _btnLimparTela;
    private ViewCanvas mViewCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewCanvas = findViewById(R.id.minha_area_de_desenho);
        _btnLimparTela = findViewById(R.id.btnLimparTela);

        _btnLimparTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparDesenho(v);
            }
        });

    }

    public void limparDesenho(View view) {
        mViewCanvas.limparTela();
    }
}
