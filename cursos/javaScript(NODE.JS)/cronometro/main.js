



const relogio = document.querySelector('.relogio');
const iniciar = document.querySelector('.iniciar');
const pausar = document.querySelector('.pausar');
const zerar = document.querySelector('.zerar');

let horas = 0
let minutos = 0
let segundos = 0
let crono= null;

iniciar.addEventListener('click', function (event) {
    if (crono === null) {
        crono = setInterval(() => {

            segundos++;
            if (segundos >= 60) {
                segundos = 0;
                minutos++;
                if (minutos >= 60) {
                    minutos = 0;
                    horas++;
                    if (horas >= 24) {
                        horas = 0;
                    }
                }
            }

            formatados()

        }, 1000);
    }
});

pausar.addEventListener('click', function (event) {
    clearInterval(crono)
    crono=null;
    
    
});

//aqui eu fiz o botão funcionar diferente 
const funcaozerar = function mostrar() {
    clearInterval(crono)
    crono=null
    segundos = 0;
    minutos = 0;
    horas = 0;
    formatados()
}

zerar.addEventListener('click', funcaozerar)


function formatados() {
    relogio.innerHTML = `${String(horas).padStart(2, '0')}:${String(minutos).padStart(2, '0')}:${String(segundos).padStart(2, '0')}`
}

