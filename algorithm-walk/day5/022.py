'''
5일차(2) - 크롤링
'''
import requests
from bs4 import BeautifulSoup

html = requests.get('https://ridibooks.com/bestsellers/general?order=weekly').text
soup = BeautifulSoup(html, 'html.parser')
print(soup)

tag_list = []
print('----------------------------------------')
z = soup.select('.title_link > .title_text')
print(z[0].text)
z = soup.select('.title_link > .title_text')
print((z[0].text).strip())

for tag in soup.select('.title_link > .title_text'):
    print(tag.text)
    if tag:
        x = tag.text
        tag_list.append()