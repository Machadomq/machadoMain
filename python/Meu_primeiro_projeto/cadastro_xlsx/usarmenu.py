from painelgu import *
from arquivo import *

# excel arquivo
cadastro_caminho = "python\Meu_primeiro_projeto\cadastro_xlsx\cadastro.xlsx"


while True:
    resposta = menu2(
        ["Sair do programa", "Cadastrar novo usuario", "Visualizar usuarios", "Procurar usuario(EM TESTE)"]
    )

    if resposta == 3:
        cabeçalho("opçao 3")
        lercadastro(cadastro_caminho)
    elif resposta == 2:
        cabeçalho("opçao 2")
        cadastronovo(cadastro_caminho)
    elif resposta == 1:
        cabeçalho("saindo do sistema... ate logo")
        break
    elif resposta==4:
        cabeçalho('Opção 4')
        nome=input('Procurar nome:')
        procurar(nome)
    else:
        print(f"{Fore.RED}Digite uma opçao valida{Style.RESET_ALL}") 


