
# Code Convention

## 1. Resource Naming
For resource naming use snake_case

|Resource| Type | Format |  
| ------ | ------ | ------ |  
|Drawable| Icon Drawable | ic_module_purpose_desc |  
|| Image Drawable | img_module_purpose_desc |   
|| Selector Drawable | selector_module_purpose_desc |  
|| Other Drawable | other_module_purpose_desc | 

## 2. Strings
For resource naming use snake_case

|Type| Format | Spec | Desc|
| ------ | ------ | ------ |  ------ |
|Title| title_module_purpose_desc | Capital Each Word | Use for title | 
|Label| label_module_purpose_desc | Capital First Word |   Use for any purpose |
|Action| action_module_purpose_desc | Capital Each Word |  Use for action like button |
|Other| other_module_purpose_desc | Freestyle | Use for something else |

## 3. Class Naming
Use PascalCase.

- For **Payload** class add **Pld** as it's suffix.
  ex: **SomePld**
- For **Model** class add **Mdl** as it's suffix.
  ex: **SomeMdl**.
  For GraphQl Model just forget about this, let graphql decide. It is the boss.

## 4. Variable Naming
Use camelCase

## 5. Compose-able Naming
Use PascalCase

## 6 Constant Naming
Use CAPITAL_SNAKE

## 7. Enum Member Naming
Use CAPITAL_SNAKE.
```  
enum SomeEnumClass {
	FIRST_MEMBER, SECOND_MEMBER, ETC
}
```  