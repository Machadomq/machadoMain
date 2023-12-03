from colorama import Fore, init, Style

init(autoreset=True)


def menu1():
    gato = 0
    while gato != "peixe":
        print("-" * 30)
        print("MENU PRINCIPAL".center(30))
        print("-" * 30)
        print(f"{Fore.CYAN}1 - Ver pessoas cadastradas{Style.RESET_ALL}")
        print(f"{Fore.CYAN}2 - Cadastrar nova pessoa{Style.RESET_ALL}")
        print(f"{Fore.CYAN}3 - Sair do sistema{Style.RESET_ALL}")
        while True:
            try:
                op = int(input("Escolha um opçao:"))
            except:
                print(f"{Fore.RED}ERRO: Digite um valor valido{Style.RESET_ALL}")
            else:
                if op == 1:
                    print("-" * 30)
                    print("Opçao 1".center(30))
                    print("-" * 30)
                    # print(pessoas.keys)
                    break
                elif op == 2:
                    print("-" * 30)
                    print("Opçao 2".center(30))
                    print("-" * 30)
                    # pessoas=input('nome da pessoa cadastrada')
                    break
                elif op == 3:
                    print("-" * 30)
                    print("Saindo do sistema... Ate logo".center(30))
                    print("-" * 30)
                    gato = "peixe"
                    break
                else:
                    print(f"{Fore.RED}ERRO: Digite um valor valido{Style.RESET_ALL}")




def leiaInt(msg):
    while True:
        try:
            n=int(input(msg))
        except (ValueError,TypeError):
            print(f'{Fore.RED}ERRO: por favor digite um numero inteiro valido.{Style.RESET_ALL}')
            continue
        except(KeyboardInterrupt):
            print(f'Usario preferiu nao digitar esse numero.')
            return 0
        else:
            return n
        
def linha(tam=42):
    return '-'*tam

def cabeçalho(txt):
    print(linha())
    print(txt.center(42))
    print(linha())

def menu2(lista):
    
    cabeçalho('MENU PRINCIPAL')
    c=1
    for item in lista:
        print(f'{Fore.CYAN}{c} - {item}{Style.RESET_ALL}')
        c+=1
    print(linha())
    opc=leiaInt(f'{Fore.YELLOW}Sua opção:{Style.RESET_ALL}')
    return opc

