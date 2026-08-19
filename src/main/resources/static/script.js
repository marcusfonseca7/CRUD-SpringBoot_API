input = document.getElementById("input")
p = document.getElementById("resposta")



async function pegarResposta() {
    const resposta = await fetch(`http://localhost:8080/teste/${input.value}`)

    const dados = await resposta.json()
    console.log(dados)

    p.innerHTML = JSON.stringify(dados.nome)
    p.innerHTML += JSON.stringify(dados.idade)
    p.innerHTML += JSON.stringify(dados.time)
}


input.addEventListener("change", () => {
    pegarResposta()
})

