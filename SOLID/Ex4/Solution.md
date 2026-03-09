How I fixed the issues:
1. Created RoomPricing class that contains an HashMap of LegacyRoomType to price, now HostelFeeCalculator can get base fee by using RoomPricing.baseFor()
2. Modified the AddOn enum to include the associated fee with the AddOn itself
Using Both RoomPricing and AddOn in conjunction we now do not require switch/ if-else statements just simple funciton call and loops

This now satisfies the Acceptance criteria
- New room type can be added without editing a switch in calculator.
- Add-ons can be added without editing the core fee algorithm.