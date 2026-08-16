execute as @e[type=minecraft:arrow,tag=railgun_arrow] run data merge entity @s {pickup:0b}

scoreboard players add @e[type=minecraft:arrow,tag=railgun_arrow] railgun_age 1

kill @e[type=minecraft:arrow,tag=railgun_arrow,scores={railgun_age=200..}]