package es.utad.entreactividades.model

import android.os.Bundle
import org.json.JSONObject
import java.security.acl.Owner

class User {
    var usuario: String = ""
    var password: String = ""
    var nombre: String = ""
    var apellidos: String = ""

    fun getBundle(): Bundle {
        var bundle = Bundle()
        bundle.putCharSequence("usuario", usuario)
        bundle.putCharSequence("password", password)
        bundle.putCharSequence("nombre", nombre)
        bundle.putCharSequence("apellidos", apellidos)

        return bundle
    }


    fun setBundle(bundle: Bundle) {
        usuario = bundle.getString("usuario", "")
        password = bundle.getString("password", "")
        nombre = bundle.getString("nombre", "")
        apellidos = bundle.getString("apellidos", "")
    }
private fun createJsonData(){
    var json = JSONObject()



}
    private fun addOwner(): JSONObject{
        return JSONObject()
                .put("usuario",usuario)
                .put("usuario",password)
                .put("usuario",nombre)
                .put("usuario",apellidos)


    }

}

