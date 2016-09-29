from django.shortcuts import render

# Create your views here.


def home(request):
    string = u"hello, world"
    TutorialList = ['html', 'css', 'jquery', 'python', 'django']
    info_dict = {'name': 'fanteathy'}
    return render(request, 'home.html', {'string': string, 'TutorialList': TutorialList, 'info_dict': info_dict})
