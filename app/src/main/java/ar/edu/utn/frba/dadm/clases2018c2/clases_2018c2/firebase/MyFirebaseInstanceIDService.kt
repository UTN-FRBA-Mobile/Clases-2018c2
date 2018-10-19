package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.firebase

import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.storage.MyPreferences
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        MyPreferences.setFirebaseToken(this, FirebaseInstanceId.getInstance().token!!)
    }
}