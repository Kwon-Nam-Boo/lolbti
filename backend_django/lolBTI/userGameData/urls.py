from django.urls import path
from . import views

app_name = 'userGameData'

urlpatterns = [
    path('test/', views.test),
    path('userinfo/<str:summonerName>', views.userInfo),
    path('recommend/mastery/<str:summonerName>', views.recommendByMastery),
    path('update/mastery/<str:summonerName>', views.updateMastery),
    path('recommend/mastery/freqchamp/<str:summonerName>',views.showFreqChamp),
    path('recommend/freqlane/<str:summonerName>',views.showFreqLane),
    path('recommend/item/<str:myChamp>/<str:opponentChamp>',views.recommendItem),
    path('recommend/mbtitomastery/<str:mbti>',views.recommendByMbti),
    path('recommend/masterytombti/<str:sohwan>',views.recommendByMastery),
]
