package com.example.firestoreprac

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNameEditText = findViewById<EditText>(R.id.firstNameEditText)
        val lastNameEditText = findViewById<EditText>(R.id.lastNameEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)


        saveButton.setOnClickListener {
            // Initialize Firebase
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()

            val user = hashMapOf(
                "firstName" to firstName,
                "lastName" to lastName
            )

            val db = FirebaseFirestore.getInstance()
            db.collection("students")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }

        }

    }
}

