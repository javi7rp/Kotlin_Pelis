fun main(args: Array<String>) {

    class pelicula (var id: Int, var titulo: String, var duracion: Int) {
        //Antes de sobreescribir el toString:
        //MainKt$main$pelicula@1ddc4ec2
        override fun toString() = "ID: $id -- titulo: $titulo -- duracion: $duracion min"
    }

    //var films = ArrayList<pelicula> ()
    var op : Int
    var salir : Boolean = false
    var encontrada : Boolean = false
    var id : Int = 0
    var id_buscar : Int
    var titulo : String
    var duracion : Int

    val films : MutableMap<Int, pelicula> = mutableMapOf()



    do {
        encontrada = false
        println("-------------MENU---------------")
        println("1-INSERTAR NUEVA PELICULA")
        println("2-MOSTRAR PELICULAS")
        println("3-BUSCAR PELICULA DADO EL CODIGO")
        println("4-BORRAR PELICULA DADO EL CODIGO")
        println("5-EDITAR PELICULA DADO EL CODIGO")
        println("6-SALIR")
        do {
            print("INTRODUCE UNA OPCION CORRECTA: ")
            op = readln().toInt()
        } while (1 > op || op > 6)


        when (op) {
            1 -> {
                id = id+1
                println("PELICULA "+id+": ")
                println("Introduce el titulo: ")
                titulo = readln()
                println("Introduce la duracion: ")
                duracion = readln().toInt()
                films[id]=pelicula(id = id, titulo = titulo, duracion = duracion)//constructor
            }

            2 -> {
                if (films.size > 0) {
                    films.forEach(){
                        println(films[it.key])
                    }

                    for (i in 0 until films.size) {


                    }
                } else {
                    println("No hay peliculas")
                }
            }
            3 -> {
                if (films.size > 0) {
                    println("Introduce el id a buscar: ")
                    id_buscar = readln().toInt()
                    if (id_buscar > 0 && id_buscar <= films.size-1){
                        println("PELICULA ENCONTRADA: ")
                        println(films[(id_buscar)])
                        encontrada = true
                    }
                    if (!encontrada){
                        println("NO SE HA ENCONTRADO LA PELICULA")
                    }
                } else {
                    println("No hay peliculas")
                }

            }
            4 -> {
                if (films.size > 0) {
                    println("Introduce el id a borrar: ")
                    id_buscar = readln().toInt()
                    if (id_buscar > 0 && id_buscar < films.size-1){
                        films.remove(id_buscar)
                        encontrada = true
                    }
                    if (!encontrada){
                        println("NO SE HA ENCONTRADO LA PELICULA")
                    }else{
                        println("PELICULA BORRADA CORRECTAMENTE")
                    }
                } else {
                    println("No hay peliculas")
                }

            }
            5 -> {
                if (films.size > 0) {
                    println("Introduce el id a modificar: ")
                    id_buscar = readln().toInt()
                    if (id_buscar > 0 && id_buscar < films.size) {
                        for (i in 0 until films.size) {
                            if (id_buscar == i) {
                                films.remove(i)
                                println("Introduce el id: ")
                                id = readln().toInt()
                                println("Introduce el titulo: ")
                                titulo = readln()
                                println("Introduce la duracion: ")
                                duracion = readln().toInt()
                                films[id_buscar]=(pelicula(id = id, titulo = titulo, duracion = duracion)) //constructor
                                encontrada = true
                            }
                        }
                    }
                    if (!encontrada){
                        println("NO SE HA ENCONTRADO LA PELICULA")
                    } else {
                        println("PELICULA MODIFICADA")
                    }
                } else {
                    println("No hay peliculas")
                }

            }
            6 -> {
                print("HA ELEGIDO SALIR")
                salir = true
            }
        }
    }while(!salir)

}