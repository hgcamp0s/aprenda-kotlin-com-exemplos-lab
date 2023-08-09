enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario, conteudo: ConteudoEducacional) {
        inscritos.add(usuario)
        println("${usuario.nome} matriculado na formação $nome com o conteúdo '${conteudo.nome}' de nível ${conteudo.nivel} e duração ${conteudo.duracao} horas")
    }
}

fun main() {
    val usuario1 = Usuario("Hugo")
    val usuario2 = Usuario("Jorge")
    val usuario3 = Usuario("Vitor")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", Nivel.INTERMEDIARIO, duracao = 120)
    val conteudo3 = ConteudoEducacional("Banco de Dados", Nivel.DIFICIL, duracao = 90)

    val formacao1 = Formacao("Desenvolvimento Android", listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Desenvolvimento Web", listOf(conteudo1, conteudo3))

    formacao1.matricular(usuario1, conteudo1)
    formacao1.matricular(usuario2, conteudo2)

    formacao2.matricular(usuario2, conteudo1)
    formacao2.matricular(usuario3, conteudo3)
}
