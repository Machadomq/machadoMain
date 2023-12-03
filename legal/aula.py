

import colorama
import requests

def dobro(num,formato=False):
    dobro=num*2
    return dobro if formato is False else moeda(dobro)

def metade(num,formato=False):
    metade=num/2
    return metade if formato is False else moeda(metade)

def porcento(num,por,formato=False):
    porcento= num+(num* por /100)
    return porcento if formato is False else moeda(porcento)


def moeda(preco=0, moeda='R$'):
    return f'{moeda}{preco:>.2f}'.replace('.',',')

def resumo(preco=0, taxaa=10,):
    print('-'* 30)
    print(f' Resumo do valor'.center(30))
    print('-'* 30)
    print(f'preco analisado: \t\t{moeda(preco)}')
    print(f'Dobro do preço é: \t\t{dobro(preco, True)}')
    print(f'A metade do preço é: \t\t{metade(preco, True)}')
    print(f'{taxaa}%  de aumento o preço fica: \t{porcento(preco,taxaa,True)}')
    print('-'* 30)

def leiadinheiro(msg):
    valido=False
    while not valido:
        entrada=str(input(msg)).replace(',','.').strip()
        if entrada.isalpha() or entrada=='':
            print(f' ERRO: "{entrada}" é um preço invalido')
        else:
            valido= True
            return float(entrada)


def leiaint():
    while True:
        try:
            num=int(input('digite um numero inteiro:'))
            print(f'o numero inteiro digitado é {num}')
            break
        except:
            print(f'{colorama.Fore.RED}ERRO: Digite um numero inteiro {colorama.Style.RESET_ALL} ')

def leiareal():
    while True:
        try:
            num=float(input('digite um numero real:'))
            print(f'o numero inteiro digitado é {num}')
            break
        except:
            print(f'{colorama.Fore.RED}ERRO: Digite um numero real. {colorama.Style.RESET_ALL} ')


def verifica_conexao_site(url):
    try:
        response = requests.get(url)

        # Verifique o código de status da resposta
        if response.status_code == 200:
            print(f"O site {url} está acessível e responde com status 200 OK.")
        else:
            print(f"O site {url} está acessível, mas responde com o código de status {response.status_code}.")

    except requests.exceptions.RequestException as e:
        print(f"O site {url} não está acessível. Ocorreu um erro: {e}")

