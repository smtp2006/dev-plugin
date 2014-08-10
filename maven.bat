
set GROUP=smtp2006
set PROJECT=dev-plugin

mvn archetype:create -DgroupId=%GROUP% -DartifactId=%PROJECT%

if %1a==a goto end

:end