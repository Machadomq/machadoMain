




function criaPessoa(nome, sobrenome, a, p){
    return {
        nome, 
        sobrenome,
        fala:function (assunto){
            return `${nome} está ${assunto}.`
        },
        altura:a,
        peso:p,
        imc(){
            const indice = this.peso / (this.altura **2);
            return indice 
        }
    };
}

const p1 = criaPessoa('luiz', 'otavio');
console.log(p1.fala('falando'));