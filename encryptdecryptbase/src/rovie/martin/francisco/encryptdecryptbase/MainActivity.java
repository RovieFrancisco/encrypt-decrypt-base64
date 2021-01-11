package rovie.martin.francisco.encryptdecryptbase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    public String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText) findViewById(R.id.input);
        final EditText result = (EditText) findViewById(R.id.result);

        Button encrypt = (Button) findViewById(R.id.encrypt);
        Button decrypt = (Button) findViewById(R.id.decrypt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = Encrypt(input.getText().toString());
                result.setText(str);
                input.setText("");
            }
        });
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = Decrypt(input.getText().toString());
                result.setText(str);
                input.setText("");
            }
        });
    }

    public String Encrypt(String text) {
        byte[] msg1 = Base64.encode(text.getBytes(), Base64.DEFAULT);
        String msg = new String(msg1);

        return msg;
    }
    public String Decrypt(String text) {
        byte[] msg1 = Base64.decode(text, Base64.DEFAULT);
        String msg = new String(msg1);

        return msg;
    }
}