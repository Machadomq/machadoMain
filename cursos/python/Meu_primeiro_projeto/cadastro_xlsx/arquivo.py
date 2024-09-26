import pandas as pd
from painelgu import *



cadastro_caminho='machado/menu/cadastro.xlsx'

def cadastronovo(caminho):
    tabela = pd.read_excel(caminho)
    nome=str(input("Nome do cliente:")).strip().lower()
    tabela.at[(len(tabela) + 1), "NOME"] = nome
    tabela.at[len(tabela), "CPF"] = input(f"CPF:").strip().lower()
    tabela.at[len(tabela), "DIVIDA"]=input(f'Valor a pagar:').strip().lower()
    tabela.at[len(tabela), "ITEM"]=input(f'Item comprado:').strip().lower()
    tabela.to_excel(caminho, index=False)


def lercadastro(caminho):
    cad = pd.read_excel(caminho)
    print(cad)


def procurar(nome):
    print(linha())
    cad=pd.read_excel(cadastro_caminho)
    if nome in cad.values:
        procurado=cad[cad['NOME']==nome]
        print(procurado)
    else:
        print(f'O {nome} não esta na lista')


