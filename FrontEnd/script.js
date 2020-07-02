
async function consultaDadosPropriedade(id) {
    //console.log(matricula);

    let url = "http://localhost:8080/consulta_propriedade/dadospropriedade";
    url = url + "?id="+id;

    try{
        let resposta = await fetch(url);
        //console.log(resposta);
        if (resposta.ok){
            let dados = await resposta.json();
            //console.log(dados);
            return dados;
        }else{
            //console.log(resposta.status+", text="+resposta.statusText);
            return null;
        }
    }catch(erro){
        console.log(erro);
    }
}

/*
// Consulta os dados do aluno
async function consultaDadosAluno(matricula) {
    //console.log(matricula);

    let url = "http://localhost:8080/consulta_aluno/dadosaluno";
    url = url + "?matricula="+matricula;

    try{
        let resposta = await fetch(url);
        //console.log(resposta);
        if (resposta.ok){
            let dados = await resposta.json();
            //console.log(dados);
            return dados;
        }else{
            //console.log(resposta.status+", text="+resposta.statusText);
            return null;
        }
    }catch(erro){
        console.log(erro);
    }
}
*/

/*
// Consulta aprovação do aluno
async function consultaAprovacao(matricula) {
    let url = "http://localhost:8080/consulta_aluno/aprovacao";
    url = url + "?matricula="+matricula;

    try{
        let resposta = await fetch(url);
        console.log(resposta);
        if (resposta.ok){
            let dados = await resposta.json();
            console.log(dados);
            return dados;
        }else{
            console.log(resposta.status+", text="+resposta.statusText);
            return null;
        }
    }catch(erro){
        console.log(erro);
    }
}

*/

// --- início do programa
document.getElementById("btConsultarDados").onclick = async function () {
    let id = document.getElementById("id").value;
    let resposta = await consultaDadosPropriedade(id);
    if (resposta != null){
        let cidade = document.getElementById("nomeCidade");
        cidade.innerHTML = resposta.cidade;
        let bairro = document.getElementById("nomeBairro");
        bairro.innerHTML = resposta.nomeBairro;
        let endereco = document.getElementById("enderecoPropriedade");
        endereco.innerHTML = resposta.endereco;
        let cep = document.getElementById("cepPropriedade");
        cep.innerHTML = resposta.cep;
        let orcamento = document.getElementById("orcamentoPropriedade");
        orcamento.innerHTML = resposta.orcamento;
        let indicadoPara = document.getElementById("statusIndicadoPropriedade");
        indicadoPara.innerHTML = resposta.indicadoPara;
        erro = document.getElementById("Error 404");
        erro.innerHTML = "";
        //let json = document.getElementById("jsonValor");
        //json.innerHTML = JSON.stringify(resposta);
    }else{
        let cidade = document.getElementById("nomeCidade");
        cidade.innerHTML = " - ";
        let bairro = document.getElementById("nomeBairro");
        bairro.innerHTML = " - ";
        let endereco = document.getElementById("enderecoPropriedade");
        endereco.innerHTML = " - ";
        let cep = document.getElementById("cepPropriedade");
        cep.innerHTML = " - ";
        let orcamento = document.getElementById("orcamentoPropriedade");
        orcamento.innerHTML = " - ";
        let indicadoPara = document.getElementById("statusIndicadoPropriedade");
        indicadoPara.innerHTML = " - ";
        erro = document.getElementById("Error 404");
        erro.innerHTML = "Erro na consulta dos dados";
    }

        /*
    document.getElementById("btAprovacao").onclick = async function () {
        matricula = document.getElementById("matricula").value;
        let resposta = await consultaAprovacao(matricula);
        if (resposta != null){
            let aprovacao = document.getElementById("aprovacao");
            if (resposta == true){
                aprovacao.innerHTML = "Aluno matricula: "+matricula+", APROVADO";
            }else{
                aprovacao.innerHTML = "Aluno matricula: "+matricula+", REPROVADO";
            }
            erro = document.getElementById("erro");
            erro.innerHTML = " - ";
        }else{
            erro = document.getElementById("erro");
            erro.innerHTML = "Erro na consulta da aprovacao";
        }  
    }  
    */
}

