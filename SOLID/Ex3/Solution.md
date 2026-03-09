How I solved the issues:
1. Created EligibilityRule class and implemented CGRRule, ...etc.. now to create a new rule we don't have to edit EligibilityEngine.evalute()
2. Now Rule configuration is separate so single class is responsible for one threshold and evaluating reason stays inside each class.
I pass a List<EligibilityRules> to the elgibility engine through constructor and in evaluate() it just loops over the list using evaluate() and getReason() on each.
