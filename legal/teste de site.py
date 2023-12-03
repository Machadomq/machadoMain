from colorama import init, Fore, Style
import urllib
import urllib.request

from aula import verifica_conexao_site
init(autoreset=True)

try:
    site = urllib.request.urlopen('https://mayanzx.github.io/Projeto-site/site/home.html')
except:
    print(f'{Fore.RED}Deu erro{Style.RESET_ALL}')
else:
    print('Tudo ok')


verifica_conexao_site('https://mayanzx.github.io/Projeto-site/site/home.html')