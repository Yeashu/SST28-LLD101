How I fixed it:
1. Extracted Parser, Validator, ConsoleOutput now Each class follows SRP
2. Creating Validator provides rules isolation that makes it easier to test
3. ConsoleOutput handles printing so Errors are not printed directly, also it makes sure that business logic and printing logic is not mixed
4. De-coupled FakeDb from OnboardingService now it uses an abstraction Database Interface which is implemented by FakeDb
5. By doing all this it makes it easier to unit test