{{/* vim: set filetype=mustache: */}}

{{/* Names of teat tier components */}}
{{- define "app-chart.test.defaultName" -}}
{{- printf "test-%s" .Release.Name -}}
{{- end -}}

{{- define "app-chart.test.name" -}}
{{- default (include "app-chart.test.defaultName" .) .Values.test.name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/* Names of facade tier components */}}
{{- define "app-chart.facade.defaultName" -}}
{{- printf "facade-%s" .Release.Name -}}
{{- end -}}

{{- define "app-chart.facade.name" -}}
{{- default (include "app-chart.facade.defaultName" .) .Values.facade.name | trunc 63 | trimSuffix "-" -}}
{{- end -}}
