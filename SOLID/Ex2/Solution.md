How I solved the issues:
1. checkout() in CafeteriaSystem had too many concerns, Now it delegates to policies and formatter and works as an orchestrator
2. Hard-coded tax rules now solved by creating TaxPolicy interface implemented by TaxRules.
3. Hard-coded discount logic solved similarly by creating DiscountPolicy interface implemented by DiscountRules
4. InvoiceFormatter makes sure that formatting and calculations are not mixed
5. Concrete persistence dependency is solved by abstracting to DatabaseStore interface, FileStore now implements it

Summary: 
Single Responsibility — Each class has one reason to change:

TaxRules: only when tax percent logic changes
DiscountRules: only when discount policy changes
InvoiceFormatter: only when format changes
FileStore: only when persistence mechanism changes
