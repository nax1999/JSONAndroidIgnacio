package es.utad.entreactividades.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible
import es.utad.entreactividades.MainActivity
import es.utad.entreactividades.R
import es.utad.entreactividades.model.User

class FormActivity : AppCompatActivity() {
    var registro:Boolean = true
    var usuario = User()

    lateinit var editTextUsuario:EditText
    lateinit var editTextPassword:EditText
    lateinit var editTextNombre:EditText
    lateinit var editTextApellidos:EditText

    lateinit var buttonCancelar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        editTextUsuario = findViewById<EditText>(R.id.Usertxt)
        editTextPassword = findViewById<EditText>(R.id.Passwordtxt)
        editTextNombre = findViewById<EditText>(R.id.Nombretxt)
        editTextApellidos = findViewById<EditText>(R.id.Apellidostxt)

        buttonCancelar = findViewById<Button>(R.id.buttonCancelar)


        registro = intent.getBooleanExtra("registro", true)

        if (!registro){
            var bundle:Bundle = intent.getBundleExtra("usuario")
            usuario.setBundle(bundle)

            editTextUsuario.setText(usuario.usuario)
            editTextPassword.setText(usuario.password)
            editTextNombre.setText(usuario.nombre)
            editTextApellidos.setText(usuario.apellidos)

            editTextUsuario.isEnabled = false
            editTextPassword.isEnabled = false
            editTextNombre.isEnabled = false
            editTextApellidos.isEnabled = false

            buttonCancelar.visibility = View.INVISIBLE
        }
    }

    fun onCancelar(view: View) {
        finish()
    }
    fun onAceptar(view: View) {
        if (registro) {
            usuario.usuario = editTextUsuario.text.toString()
            usuario.password = editTextPassword.text.toString()
            usuario.nombre = editTextNombre.text.toString()
            usuario.apellidos = editTextApellidos.text.toString()

            var resultIntent = Intent(this, MainActivity::class.java)
            resultIntent.putExtra("usuario", usuario.getBundle())

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        else{
            finish()
        }
    }
}