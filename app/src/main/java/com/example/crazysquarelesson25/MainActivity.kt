package com.example.crazysquarelesson25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var cvadr: LinearLayout
    lateinit var cLayout: ConstraintLayout
    lateinit var btnSbrosCvadr: Button
    private val scope = CoroutineScope(Dispatchers.IO)
    private lateinit var job: Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSbrosCvadr = findViewById(R.id.btnSbrosCvadr)
        cvadr = findViewById(R.id.cvadr)
        cLayout = findViewById(R.id.cLayout)
        var bul = true
        var valueX = 0f
        var valueY = 0f
        cvadr.setOnClickListener {
            bul = true
            job = scope.launch {
                while (bul) {
                    if (cvadr.x < cLayout.width - cvadr.width) {
                        while (cvadr.x < cLayout.width - cvadr.width) {
                            delay(50)
                            valueX = valueX + 10f
                            valueY = valueY + 10f
                            withContext(Dispatchers.Main) {
                                cvadr.translationX = valueX
                                cvadr.translationY = -valueY
                            }
                        }
                    } else {
                        while (cvadr.x > 0 && cvadr.y > cLayout.height - cvadr.height) {
                            delay(50)
                            valueX = valueX - 10f
                            valueY = valueY + 10f
                            withContext(Dispatchers.Main) {
                                cvadr.translationX = valueX
                                cvadr.translationY = -valueY
                            }
                        }
                    }

                    while (cvadr.y > 0f && cvadr.x > 0) {
                        delay(50)
                        valueX = valueX - 10f
                        valueY = valueY + 10f
                        withContext(Dispatchers.Main) {
                            cvadr.translationX = valueX
                            cvadr.translationY = -valueY
                        }
                    }
                    if (cvadr.x > 0f) {
                        while (cvadr.x > 0f) {
                            delay(50)
                            valueX = valueX - 10f
                            valueY = valueY - 10f
                            withContext(Dispatchers.Main) {
                                cvadr.translationX = valueX
                                cvadr.translationY = -valueY
                            }
                        }
                    } else {
                        while (cvadr.y > 0f && cvadr.x < cLayout.width) {
                            delay(50)
                            valueX = valueX + 10f
                            valueY = valueY + 10f
                            withContext(Dispatchers.Main) {
                                cvadr.translationX = valueX
                                cvadr.translationY = -valueY
                            }
                        }
                    }
                    while (cvadr.y < cLayout.height - cvadr.height && cvadr.x < cLayout.width - cvadr.height) {
                        delay(50)
                        valueX = valueX + 10f
                        valueY = valueY - 15f
                        withContext(Dispatchers.Main) {
                            cvadr.translationX = valueX
                            cvadr.translationY = -valueY
                        }

                    }

                }
            }


        }
        btnSbrosCvadr.setOnClickListener {
            job.cancel()
            bul = false
            cvadr.translationX = 0f
            cvadr.translationY = 0f
            valueX = 0f
            valueY = 0f
        }

    }
}