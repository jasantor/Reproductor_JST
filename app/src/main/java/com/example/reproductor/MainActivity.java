package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaramos las variables objetos
    Button play_pause, btn_repetir; //creamos los objetos botones para la reproducción y cambio de imagen.
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion;//índice de nuestro array
    Thread updateSeekBar;

    //Meadia Player nos permite reproducir audios largos,
    MediaPlayer vectormp[] = new MediaPlayer[10];//aquí guardamos las pistas de audio.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dirigimos las variables de la parte lógica a la pare gráfica.
        play_pause = (Button) findViewById(R.id.btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        iv = (ImageView) findViewById(R.id.imageView2);
        //introducimos las canciones en el array.
        //con .create introducimos la canción en el vector 10 canciones.
        vectormp[0] = MediaPlayer.create(this, R.raw.anna_yvette_running_out_of_time);
        vectormp[1] = MediaPlayer.create(this, R.raw.beave_talk);
        vectormp[2] = MediaPlayer.create(this, R.raw.coopex_nito);
        vectormp[3] = MediaPlayer.create(this, R.raw.dig_ex_fall_in_love);
        vectormp[4] = MediaPlayer.create(this, R.raw.diviners_azertion_reality);
        vectormp[5] = MediaPlayer.create(this, R.raw.goodknight_freedom);
        vectormp[6] = MediaPlayer.create(this, R.raw.oblvyn_xriell_with_you);
        vectormp[7] = MediaPlayer.create(this, R.raw.ryvn_avatar);
        vectormp[8] = MediaPlayer.create(this, R.raw.tollef_take_our_time);
        vectormp[9] = MediaPlayer.create(this, R.raw.zack_merci_ray_of_light);
    }

    //Método para el botón PlayPause
    public void PlayPause(View view) {
        //ahora verificamos si se está reproduciendo una canción
        if (vectormp[posicion].isPlaying()) { //con isPlaying sabremos, si se está reproduciendo o no.
            vectormp[posicion].pause();//si se está reproduciendo, se tien que pausar la canción.
            play_pause.setBackgroundResource(R.drawable.iplay); //cambia la imagen del botón
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {

            for (posicion = 0; posicion <= vectormp.length; posicion++) { //para hecer que se reproduzcan todas las canciones.
                if (posicion == 0) {iv.setImageResource(R.drawable.song1);}
                vectormp[posicion].start();    // para la reproducción.
                play_pause.setBackgroundResource(R.drawable.ipausa); //cambia imagen del botón.
                Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    //Método para el botón Stop
    public void Stop(View view) {
        if (vectormp[posicion] != null) { // comprobar que está ocupado.
            vectormp[posicion].stop(); //para parar la reproducción, método MadiaPlayer.

            vectormp[0] = MediaPlayer.create(this, R.raw.anna_yvette_running_out_of_time);
            vectormp[1] = MediaPlayer.create(this, R.raw.beave_talk);
            vectormp[2] = MediaPlayer.create(this, R.raw.coopex_nito);
            vectormp[3] = MediaPlayer.create(this, R.raw.dig_ex_fall_in_love);
            vectormp[4] = MediaPlayer.create(this, R.raw.diviners_azertion_reality);
            vectormp[5] = MediaPlayer.create(this, R.raw.goodknight_freedom);
            vectormp[6] = MediaPlayer.create(this, R.raw.oblvyn_xriell_with_you);
            vectormp[7] = MediaPlayer.create(this, R.raw.ryvn_avatar);
            vectormp[8] = MediaPlayer.create(this, R.raw.tollef_take_our_time);
            vectormp[9] = MediaPlayer.create(this, R.raw.zack_merci_ray_of_light);

            posicion = 0; //regresa a la posición 0;
            play_pause.setBackgroundResource(R.drawable.iplay); //cambia la apariencia del botón.
            iv.setImageResource(R.drawable.imgreproduc); // Cambia la protada a la de inicio.
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show(); //mesaje Stop.
        }
    }

    //Método repetir una pista
    public void Repetir(View view) {
        if (repetir == 1) { // el botón tiene que cambiar la imagen.
            btn_repetir.setBackgroundResource(R.drawable.irepetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false); //con este método deja repetir o no una canción.
            repetir = 2; //declarada al inicio =2.
        } else {
            btn_repetir.setBackgroundResource(R.drawable.i2repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true); // con true se repite la canción.
            repetir = 1; // no se repite;
        }
    }

    // Método para saltar a la siguiente cancion.
    public void Siguiente(View view) {
        if (posicion < vectormp.length - 1) {  // sin desbordamineto de memoria, permite seguir recorriendo.

            if (vectormp[posicion].isPlaying()) { //en reproducción.
                vectormp[posicion].stop(); //pista detenida.
                posicion++; // incrementa de 1 en 1.
                vectormp[posicion].start(); // pista comienza a reproducir.
                //Condición para cambiar portada
                if (posicion == 0) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.song2);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.song3);
                } else if (posicion == 3) {
                    iv.setImageResource(R.drawable.song4);
                } else if (posicion == 4) {
                    iv.setImageResource(R.drawable.song5);
                } else if (posicion == 5) {
                    iv.setImageResource(R.drawable.song6);
                } else if (posicion == 6) {
                    iv.setImageResource(R.drawable.song7);
                } else if (posicion == 7) {
                    iv.setImageResource(R.drawable.song8);
                } else if (posicion == 8) {
                    iv.setImageResource(R.drawable.song9);
                } else if (posicion == 9) {
                    iv.setImageResource(R.drawable.song10);
                }

            } else {
                posicion++;
                //cambio de imagenes en la portada.
                if (posicion == 0) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.song2);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.song3);
                } else if (posicion == 3) {
                    iv.setImageResource(R.drawable.song4);
                } else if (posicion == 4) {
                    iv.setImageResource(R.drawable.song5);
                } else if (posicion == 5) {
                    iv.setImageResource(R.drawable.song6);
                } else if (posicion == 6) {
                    iv.setImageResource(R.drawable.song7);
                } else if (posicion == 7) {
                    iv.setImageResource(R.drawable.song8);
                } else if (posicion == 8) {
                    iv.setImageResource(R.drawable.song9);
                } else if (posicion == 9) {
                    iv.setImageResource(R.drawable.song10);
                }
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para regresar a la canción anterior
    public void Anterior(View view) {
        if (posicion >= 1) { // para no retroceder de lo que debe.
            if (vectormp[posicion].isPlaying()) { //saber si se está reproduciendo.
                vectormp[posicion].stop(); // para parar reproducción.

                vectormp[0] = MediaPlayer.create(this, R.raw.anna_yvette_running_out_of_time);
                vectormp[1] = MediaPlayer.create(this, R.raw.beave_talk);
                vectormp[2] = MediaPlayer.create(this, R.raw.coopex_nito);
                vectormp[3] = MediaPlayer.create(this, R.raw.dig_ex_fall_in_love);
                vectormp[4] = MediaPlayer.create(this, R.raw.diviners_azertion_reality);
                vectormp[5] = MediaPlayer.create(this, R.raw.goodknight_freedom);
                vectormp[6] = MediaPlayer.create(this, R.raw.oblvyn_xriell_with_you);
                vectormp[7] = MediaPlayer.create(this, R.raw.ryvn_avatar);
                vectormp[8] = MediaPlayer.create(this, R.raw.tollef_take_our_time);
                vectormp[9] = MediaPlayer.create(this, R.raw.zack_merci_ray_of_light);

                posicion--;

                //Condición para cambiar portada
                if (posicion == 0) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.song2);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.song3);
                } else if (posicion == 3) {
                    iv.setImageResource(R.drawable.song4);
                } else if (posicion == 4) {
                    iv.setImageResource(R.drawable.song5);
                } else if (posicion == 5) {
                    iv.setImageResource(R.drawable.song6);
                } else if (posicion == 6) {
                    iv.setImageResource(R.drawable.song7);
                } else if (posicion == 7) {
                    iv.setImageResource(R.drawable.song8);
                } else if (posicion == 8) {
                    iv.setImageResource(R.drawable.song9);
                } else if (posicion == 9) {
                    iv.setImageResource(R.drawable.song10);
                }
                vectormp[posicion].start(); //reproducir canción.
            } else {
                posicion--;
                //Condición para cambiar portada
                if (posicion == 0) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.song2);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.song3);
                } else if (posicion == 3) {
                    iv.setImageResource(R.drawable.song4);
                } else if (posicion == 4) {
                    iv.setImageResource(R.drawable.song5);
                } else if (posicion == 5) {
                    iv.setImageResource(R.drawable.song6);
                } else if (posicion == 6) {
                    iv.setImageResource(R.drawable.song7);
                } else if (posicion == 7) {
                    iv.setImageResource(R.drawable.song8);
                } else if (posicion == 8) {
                    iv.setImageResource(R.drawable.song9);
                } else if (posicion == 9) {
                    iv.setImageResource(R.drawable.song10);
                }
            }
        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }
}
