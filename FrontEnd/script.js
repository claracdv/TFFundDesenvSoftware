function realizaPagamento() {
    alert("Pagamento realizado!");
}

async function consultaDadosPropriedade(idPropriedade) {
    //console.log(matricula);

    let url = "http://localhost:8080/consulta_propriedade/dadospropriedade";
    url = url + "?id="+idPropriedade;

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

async function consultaDadosCliente(cpf) {
    //console.log(matricula);

    let url = "http://localhost:8080/consulta_cliente/dadoscliente";
    url = url + "?cpf="+cpf;

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


// --- início do programa
document.getElementById("btConsultarDadosPropriedade").onclick = async function () {

    let idPropriedade = document.getElementById("idPropriedade").value;
    let resposta = await consultaDadosPropriedade(idPropriedade);
    if (resposta != null){
        let cidade = document.getElementById("nomeCidade");
        cidade.innerHTML = resposta.cidade;

        let bairro = document.getElementById("nomeBairro");
        bairro.innerHTML = resposta.bairro;

        let endereco = document.getElementById("enderecoPropriedade");
        endereco.innerHTML = resposta.endereco;

        let cep = document.getElementById("cepPropriedade");
        cep.innerHTML = resposta.cep;

        let orcamento = document.getElementById("orcamentoPropriedade");
        orcamento.innerHTML = resposta.orcamentoIndicado;

        let indicadoPara = document.getElementById("statusIndicadoPropriedade");
        indicadoPara.innerHTML = resposta.indicadaPara;

        let custoPropriedade = document.getElementById("custoProp");
        custoPropriedade.innerHTML = resposta.custo;

        let custoBairroProp = document.getElementById("custoBairro");
        custoBairroProp.innerHTML = resposta.custoBairro;

        let ocupada = document.getElementById("propriedadeOcupada");
        ocupada.innerHTML = resposta.ocupada;

        erro = document.getElementById("erro");
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
        let custo = document.getElementById("custoPropriedade");
        custo.innerHTML = " - ";
        let ocupada = document.getElementById("propriedadeOcupada");
        ocupada.innerHTML = " - ";
        erro = document.getElementById("erro");
        erro.innerHTML = "Erro na consulta dos dados";
    }
}
document.getElementById("btConsultarDadosCliente").onclick = async function () {
    let cpf = document.getElementById("cpf").value;
    let resposta = await consultaDadosCliente(cpf);
    if (resposta != null){
        let dataNascimento = document.getElementById("dataNascimentoCliente");
        dataNascimento.innerHTML = resposta.dataNascimento;
    
        let numAlugueis = document.getElementById("numAlugueisCliente");
        numAlugueis.innerHTML = resposta.numAlugueis;

        let formaPagamento = document.getElementById("formaPagamentoCliente");
        formaPagamento.innerHTML = resposta.formaPagamento;
    
        let orcamentoC = document.getElementById("orcamentoCliente");
        orcamentoC.innerHTML = resposta.orcamento;

        let statusC = document.getElementById("statusCliente");
        statusC.innerHTML = resposta.statusCliente;
    
        let cidadeC = document.getElementById("cidadeCliente");
        cidadeC.innerHTML = resposta.cidadeCliente;

        let descontoC = document.getElementById("desconto");
        descontoC.innerHTML = resposta.desconto;

        let custoTotalP = document.getElementById("custoTotal");
        custoTotalP.innerHTML = resposta.custoTotal;
    
    
        erro = document.getElementById("erro");
        erro.innerHTML = "";
            //let json = document.getElementById("jsonValor");
            //json.innerHTML = JSON.stringify(resposta);
    }else{

        let dataNascimento = document.getElementById("dataNascimentoCliente");
        dataNascimento.innerHTML = " - ";
    
        let numAlugueis = document.getElementById("numAlugueisCliente");
        numAlugueis.innerHTML = " - ";

        let formaPagamento = document.getElementById("formaPagamentoCliente");
        formaPagamento.innerHTML = " - ";
    
        let statusC = document.getElementById("statusCliente");
        statusC.innerHTML = " - ";
    
        let orcamentoC = document.getElementById("orcamentoCliente");
        orcamentoC.innerHTML = " - ";
    
        let cidadeC = document.getElementById("cidadeCliente");
        cidadeC.innerHTML = " - ";
            erro = document.getElementById("erro");
            erro.innerHTML = "Erro na consulta dos dados";
        }

        let butCheckout = document.getElementById("butCheckout");
        butCheckout.onclick = checkout;
}

document.getElementById("btPagar").onclick = async function (){
    let butCheckout = document.getElementById("btPagar");
        butCheckout.onclick = realizaPagamento;
}