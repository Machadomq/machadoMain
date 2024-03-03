from colorama import Fore, init, Style

init(autoreset=True)


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
    opcao=leiaInt(f'{Fore.YELLOW}Sua opção:{Style.RESET_ALL}')
    return opcao


