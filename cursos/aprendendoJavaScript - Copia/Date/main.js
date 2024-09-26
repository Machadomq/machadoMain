

let data= new Date()
console.log(data.toString())

let dia=data.getDate()
let mes=data.getMonth()
let ano=data.getFullYear()
let hora=data.getHours()
let min =data.getMinutes()
let diaSemana= data.getDay()
let sec=data.getSeconds()

switch (mes){
    case 0:
        mes='Janeiro'
        break
    case 1:
        mes='Fevereiro'
        break
    case 2:
        mes = 'Março';
        break;
    case 3:
        mes = 'Abril';
        break;
    case 4:
        mes = 'Maio';
        break;
    case 5:
        mes = 'Junho';
        break;
    case 6:
        mes = 'Julho';
        break;
    case 7:
        mes = 'Agosto';
        break;
    case 8:
        mes = 'Setembro';
        break;
    case 9:
        mes = 'Outubro';
        break;
    case 10:
        mes = 'Novembro';
        break;
    case 11:
        mes = 'Dezembro';
        break;
    default:
        mes = 'Mês não reconhecido';
        break;
}

switch (diaSemana){
    case 0:
        diaSemana='Domingo'
        break;
    case 1:
        diaSemana='Segunda-Feira'
        break
        case 2:
        diaSemana='Terça-Feira'
        break
    case 3:
        diaSemana='Quarta-Feira'
        break
    case 4:
        diaSemana='Quinta-Feira'
        break
    case 5:
        diaSemana='Sexta-Feira'
        break
    case 6:
        diaSemana='Sabado'
        break
}

if (sec<10){
    sec=`0${sec}`
}


if (mes<10){
    mes=`0${mes}`
}

if (min<10){
    min=`0${min}`
}
function mostrar(){
    let pegarp=document.querySelector('#meup')
    pegarp.innerHTML=`Você acessou este arquivo dia:<br/> ${dia} de ${mes} de ${ano} as ${hora}:${min}:${sec} (${diaSemana})`
}
mostrar()







