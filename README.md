# CalendarView

1. Responsywność interfejsu:
Interfejs w zależności od rozmiaru wyświetlacza zwiększa bądź zmniejsza przestrzenie między kontrolkami w celu zajęcia całej dostępnej przestrzeni

2. Niezawodność:
- Brak dodatkowych działań po uruchomieniu aplikacji
- W przypadku wejścia innego okna na pierwszy plan aplikacja nie zatrzymuje swojego działania
- Po powrocie do okna aplikacja działa dalej od momentu w którym pozostawił ją użytkownik
- W momencie zatrzymania działania aplikacja czyści dane podane przez użytkownika, wracając do swojego stanu przed uruchomieniem
- Przy ponownym powrocie aplikacji po zatrzymaniu działania użytkownik spotyka aplikację w stanie pierwotnym
- Aplikacja wymaga 16 MB pamięci
- "Zabicie" aplikacji powoduje usunięcie wszytskich danych wprowadzonych przez użytkownika. Po ponownym uruchomieniu użytkownik spotyka aplikację w stanie pierwotnym
- Aplikacj anie wykonuje żadnych dodatkowych działań po jej zamknięciu

3. Wybór środowiska:
Aplikacja wykonana w programie Android Studio na systemy Android

4. Weryfikacja i testowanie:
Aplikacja testowana na urządzeniach z systemami Android 12 oraz Android 11
