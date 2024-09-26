


const form = document.querySelector('#formulario');

form.addEventListener('submit', function (e) {
    e.preventDefault();
    const inputPeso= e.target.querySelector('#peso');
    const inputAltura= e.target.querySelector('#altura');
    
    const peso=Number(inputPeso.value);
    const altura =Number(inputAltura.value);

     if (!peso){
        setResultado('Peso invalido', false);
        return;
     }

     if (!altura){
        setResultado('Altura invalida', false)
        return;
     }
     
     const imc = getIMC(peso, altura);
     const nivelIMC= getNivelIMC(imc);


     const msg = `Seu IMC é ${imc} (${nivelIMC}).`;
     
     
     setResultado(msg, true)
});


function getNivelIMC(imc){
    const nivel=['abaixo do peso', 'peso normal', 'sobrepeso',' obesidade grau 1', 'obesidade grau 2', 'obesidade grau3' ]

    if(imc>40) return nivel[5]
    if (imc>=35) return nivel[4]
    if (imc>=30) return nivel[3]
    if (imc>=25) return nivel[2]
    if (imc>=18.5) return nivel [1]
    if (imc<18.5) return nivel[0]
}


function getIMC(peso, altura){
    const imc =peso /altura**2;
    return imc.toFixed(2);
}


function criaP(){
    const p = document.createElement('p');
    p.classList.add('paragrafo-resultado')
  return p;
}

function setResultado(msg, isValid) {
    const resultado = document.querySelector('#resultado');
    resultado.innerHTML = '';

    const p = criaP();

    if (isValid) {
        p.classList.add('paragrafo-resultado');
    } else {
        p.classList.add('bad');
    }
    p.innerHTML=msg
    resultado.appendChild(p)
}



