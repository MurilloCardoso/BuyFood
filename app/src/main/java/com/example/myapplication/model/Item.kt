package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.R
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val drawable: String,

) {

    constructor(name: String, price: Double) : this(0, name, price, "", "")
}
enum class OpcoesMenu(val valor: Int) {
    Erro(0),Hamburguer(1), Almoco(2), ComidaOriental(3), Salgados(4), Doces(5)

}