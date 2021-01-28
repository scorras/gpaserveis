package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.business.AuditServeisService;
import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.audit.AuditServeisBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearRequerimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocsAssociatsIntraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentEntradaFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentTramitacioFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarRequerimentFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaCompletarDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaCompletarDocumentTramitacioExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDigitalitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDigitalitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEsborrarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEsborrarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaIncorporarNouDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaIncorporarNouDocumentTramitacioExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaObtenirDocumentEntradaIntraoperabilitatExpedientRDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaPrepararRequerimentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaPresentarDeclaracioResponsableExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaRebutjarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaValidarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.AnotarOperacioComptableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentCrearNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentGeneratRegistrarComunicatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRedireccionarAssentamentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRetornarTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsTornarEnrereBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.InscriureEnRegistreBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ObtenirPerInteroperabilitatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaActualitzarTerceraPersonaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaAnotarOperacioComptableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaConsultaExpedientsBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaCrearTerceraPersonaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaEsborrarTerceraPersonaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsAbandonarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsAccesBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsArxivarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsDocumentSignatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsNotificarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsPausarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsProposarResolucioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsReactivarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsRegistrarComunicacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsRetornarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsTancarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsTornarEnrereBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaFinalitzarSignarManuscritaDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaInscriureEnRegistreBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaObtenirPerInteroperabilitatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaPublicarPerAInformacioPublicaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaResolucioValidarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaSignarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioRequeritsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CrearNotificacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsAssociatsIntra;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsFisics;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRegistrarComunicat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRevisio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.GuardarRequerimentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentMassiu;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RegistreAssentament;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Requeriments;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarPortasignaturesDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegellDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTabletDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTabletDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AcumularExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AnotarOperacioComptableRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ComentariCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.InscriureEnRegistreRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ObtenirPerInteroperabilitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RedireccioAssentament;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaInteroperabilitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornTramitacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornarTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Sollicituds;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TornarEnrereRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsOrganigramaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UsuarisRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.handler.ServeisRestControllerExceptionHandler;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerValidationHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerVisibilitatHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.common.BooleanApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.ConfiguracioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.RevisioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusAccionsPortaSigApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusSignaturaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.MotiuPausaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusCanalComunicacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TransicioAccioEstatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitOvtApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.ConfiguracioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusSignaturaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatCiutadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.MotiuPausaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusCanalComunicacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.VersioProcedimentApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ErrorDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ActualitzarTerceraPersonaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.CrearTerceraPersonaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.RespostaActualitzarTerceraPersonaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.RespostaCrearTerceraPersonaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.RespostaEsborrarTerceraPersonaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.TerceraPersonaSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar.ExpedientActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar.RespostaActualitzarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.resolucio.validar.RespostaResolucioValidarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.PreparacioSignaturaCriptograficaDocumentMassiuRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.PreparacioSignaturaCriptograficaDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.RespostaFinalitzarSignarManuscritaDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.RespostaPrepararSignaturaDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.RespostaSignarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.SignaturaDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.SignaturaValidDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.recurs.RecursExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.recurs.RespostaRecursExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.revisar.ExpedientRevisarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.revisar.RespostaRevisarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.ExpedientsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.RespostaCercaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentAportatConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.ExpedientConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.RespostaConsultaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.completar.DocumentComplecioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.completar.RespostaCompletarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.DocumentDigitalitzacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.RespostaDigitalitzarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.esborrar.DocumentacioEsborrarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.DocumentIncorporacioNouRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.RespostaIncorporarNouDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.intraoperabilitat.DocumentIntraoperabilitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.intraoperabilitat.RespostaObtenirDocumentIntraoperabilitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.RequerimentPreparacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.RespostaPrepararRequerimentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.presentar.declaracio.responsable.DeclaracioResponsablePresentacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.presentar.declaracio.responsable.RespostaPresentarDeclaracioResponsableRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.rebutjar.DocumentAportatRebutjarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.rebutjar.RespostaRebutjarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.validar.DocumentAportatValidarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.validar.RespostaValidarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.abandonar.ExpedientAbandonamentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.abandonar.RespostaAbandonarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acces.ExpedientAccesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acces.RespostaAccesExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acumular.ExpedientAcumulacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acumular.RespostaAcumularExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.anotar.operacio.comptable.OperacioComptableRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.anotar.operacio.comptable.RespostaAnotarOperacioComptableRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.arxivar.ExpedientArxiuRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.arxivar.RespostaArxivarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.certificar.CertificarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.certificar.RespostaCertificarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.comunicar.ExpedientComunicatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.comunicar.RespostaRegistrarComunicacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.inscriure.en.registre.InscriureRegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.inscriure.en.registre.RespostaInscriureEnRegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar.ExpedientNotificacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar.RespostaNotificarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar.ExpedientPausaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar.RespostaPausarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.publicar.InformacioPublicaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.publicar.RespostaPublicarPerAInformacioPublicaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.reactivar.ExpedientReactivacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.reactivar.RespostaReactivarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.resolucio.proposar.ExpedientPropostaResolucioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.resolucio.proposar.RespostaProposarResolucioExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.signat.ExpedientDocumentSignatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.signat.RespostaDocumentSignatExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tancar.ExpedientTancamentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tancar.RespostaTancarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tornar.ExpedientTornadaEnrereRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tornar.RespostaTornarEnrereExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.convidar.ExpedientConvidarTramitarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.convidar.RespostaConvidarTramitarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.retornar.ExpedientRetornRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.retornar.RespostaRetornarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.unitatsgestores.canviar.ExpedientCanviUnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.unitatsgestores.canviar.RespostaCanviarUnitatGestoraExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.validar.ExpedientValidacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.validar.RespostaValidarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.interoperabilitat.ObtenirPerInteroperabilitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.interoperabilitat.RespostaObtenirPerInteroperabilitatRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.configuration.annotation.EntornPropertySource;
import net.opentrends.openframe.services.security.core.userdetails.ImiUserDetails;
import net.opentrends.openframe.services.security.util.SecurityUtils;

/**
 * The Class ServeisTramitadorsRestController.
 */
@RestController
@RequestMapping(value = "/serveis/tramitadors", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Tramitadors API", tags = "Serveis Tramitadors API")
/** The Constant log. */
@CommonsLog
@EntornPropertySource(value = { "classpath:/app/config/gpaserveis.properties" })
public class ServeisTramitadorsRestController extends BaseRestController {

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/** The expedients id organ. */
	@Value("${expedients.id.organ}")
	private String expedientsIdOrgan;

	/** The audit serveis service. */
	@Autowired
	private AuditServeisService auditServeisService;

	/**
	 * Cerca expedients.
	 *
	 * @param resultatsPerPagina
	 *            the resultats per pagina
	 * @param numeroPagina
	 *            the numero pagina
	 * @param ordenarPer
	 *            the ordenar per
	 * @param sentitOrdenacio
	 *            the sentit ordenacio
	 * @param codiExpedient
	 *            the codi expedient
	 * @param nifSollicitant
	 *            the nif sollicitant
	 * @param nomCognomSollicitant
	 *            the nom cognom sollicitant
	 * @param dataPresentacioInici
	 *            the data presentacio inici
	 * @param dataPresentacioFi
	 *            the data presentacio fi
	 * @param codiProcediment
	 *            the codi procediment
	 * @param versioProcediment
	 *            the versio procediment
	 * @param estat
	 *            the estat
	 * @param unitatGestora
	 *            the unitat gestora
	 * @param tramitador
	 *            the tramitador
	 * @param aplicacioNegoci
	 *            the aplicacio negoci
	 * @return the resposta cerca expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/expedients")
	@ApiOperation(nickname = "cercaExpedientsTramitadors", value = "Cerca d'expedients", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCercaExpedientsRDTO cercaExpedients(
	        @ApiParam(value = "Indicarà el número de resultats per pàgina") @RequestParam(value = "resultatsPerPagina", required = false, defaultValue = "20") int resultatsPerPagina,
	        @ApiParam(value = "Indicarà en quina pàgina hauria de començar els resultats demanats en una cerca") @RequestParam(value = "numeroPagina", required = false, defaultValue = "1") int numeroPagina,
	        @ApiParam(value = "Indicarà el camp mitjançant el qual s'ordenarà el resultat de la cerca", allowableValues = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String ordenarPer,
	        @ApiParam(value = "Indicarà el sentit d'ordenació per al resultat de la cerca", allowableValues = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String sentitOrdenacio,
	        @ApiParam(value = "Filtra expedients per codi") @RequestParam(value = "codiExpedient", required = false) String codiExpedient,
	        @ApiParam(value = "Filtra expedients per document d'identificació del sollicitant") @RequestParam(value = "nifSollicitant", required = false) String nifSollicitant,
	        @ApiParam(value = "Filtra expedients per nom i cognom del sollicitant") @RequestParam(value = "nomCognomSollicitant", required = false) String nomCognomSollicitant,
	        @ApiParam(value = "Filtra expedients per data de presentació (format dd/MM/aaaa)") @RequestParam(value = "dataPresentacioInici", required = false) String dataPresentacioInici,
	        @ApiParam(value = "Filtra expedients per data de presentació (format dd/MM/aaaa)") @RequestParam(value = "dataPresentacioFi", required = false) String dataPresentacioFi,
	        @ApiParam(value = "Filtra expedients per un conjunt de codis de procediment") @RequestParam(value = "codiProcediment", required = false) String[] codiProcediment,
	        @ApiParam(value = "En cas que s'indiqui codi de procediment, filtra expedients per versió de procediment", allowableValues = VersioProcedimentApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = VersioProcedimentApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = VersioProcedimentApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String versioProcediment,
	        @ApiParam(value = "Filtra expedients per conjunt d'estats", allowableValues = EstatCiutadaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = EstatCiutadaApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String[] estat,
	        @ApiParam(value = "Filtra expedients per Unitat Gestora") @RequestParam(value = "unitatGestora", required = false) String unitatGestora,
	        @ApiParam(value = "Filtra procediments per aplicació de tramitació", allowableValues = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TramitadorApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TramitadorApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String tramitador,
	        @ApiParam(value = "En cas que el tramitador sigui una aplicació de negoci, filtra procediments pel nom de dita aplicació") @RequestParam(value = "aplicacioNegoci", required = false) String aplicacioNegoci)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug(
			        "cercaExpedients(int, int, String, String, String, String, String, String, String, String[], String, String[], String, String, String) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaCercaExpedientsRDTO resposta = new RespostaCercaExpedientsRDTO();
		List<ExpedientsCercaRDTO> expedientsCercaRDTOList = new ArrayList<ExpedientsCercaRDTO>();

		// Data
		// Unitats Gestores que hacen match con el parámetro unitatGestora
		UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(unitatGestora);
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = serveisService.cercaUnitatsGestores(unitatsGestoresCercaBDTO);

		// Expedients que cumplen los criterios de búsqueda
		ExpedientsCercaBDTO expedientsCercaBDTO = new ExpedientsCercaBDTO(
		        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan), nifSollicitant,
		        nomCognomSollicitant, dataPresentacioInici, dataPresentacioFi,
		        ExpedientsApiParamToInternalMapper.getCodiProcedimentInternalValueList(codiProcediment),
		        ExpedientsApiParamToInternalMapper.getVersioProcedimentInternalValue(versioProcediment),
		        ExpedientsApiParamToInternalMapper.getEstatCiutadaInternalValueList(estat),
		        ExpedientsApiParamToInternalMapper.getIdUnitatGestoraInternalValueList(unitatsGestoresRDTOList),
		        ExpedientsApiParamToInternalMapper.getTramitadorInternalValue(tramitador), aplicacioNegoci, numeroPagina,
		        resultatsPerPagina, ExpedientsApiParamToInternalMapper.getOrdenarPerInternalValue(ordenarPer),
		        ExpedientsApiParamToInternalMapper.getSentitOrdenacioInternalValue(sentitOrdenacio), null);

		RespostaExpedientsCercaBDTO respostaExpedientsCercaBDTO = new RespostaExpedientsCercaBDTO();
		try {
			respostaExpedientsCercaBDTO = serveisService.cercaExpedients(expedientsCercaBDTO);

			for (DadesExpedientBDTO dadesExpedientBDTO : respostaExpedientsCercaBDTO.getDadesExpedientBDTOList()) {
				expedientsCercaRDTOList.add(modelMapper.map(dadesExpedientBDTO, ExpedientsCercaRDTO.class));
			}
			resposta.setData(expedientsCercaRDTOList);

			// Paginació
			resposta.setPaginacio(modelMapper.map(respostaExpedientsCercaBDTO.getPaginationAttributes(), PaginacioRDTO.class));

		} catch (GPAServeisServiceException e) {
			log.error(
			        "cercaExpedients(int, int, String, String, String, String, String, String, String[], String, String[], String, String, String) - inici",
			        e); // $NON-NLS-1$
			resultatAudit = "KO";
			ex = e;
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("GET");
			auditServeisBDTO.setValueAccio("Cerca d'expedients");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientsCercaBDTO, respostaExpedientsCercaBDTO, ex);
		}
		if (log.isDebugEnabled()) {
			log.debug(
			        "cercaExpedients(int, int, String, String, String, String, String, String, String[], String, String[], String, String, String) - fi"); //$NON-NLS-1$
		}
		return resposta;
	}

	/**
	 * Consultar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the resposta consulta expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/expedients/{codiExpedient}/consultar")
	@ApiOperation(nickname = "consultarExpedientTramitadors", value = "Consultar les dades de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaExpedientsRDTO consultar(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("consultar(String) - inici"); //$NON-NLS-1$
		}
        logImiUser();

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaConsultaExpedientsRDTO respostaConsultaExpedientsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_OBTENIR_EXPEDIENT);
		DadesExpedientBDTO dadesExpedientBDTO = null;
		ExpedientConsultaRDTO expedientConsultaRDTO = null;

		try {
			respostaConsultaExpedientsRDTO = new RespostaConsultaExpedientsRDTO();

			// desde tramitadors no se controla la visibilidad, solo afecta a
			// portal
			BigDecimal visibilitat = BigDecimal.ONE;

			// Datos principales del expedient
			dadesExpedientBDTO = serveisService.consultarDadesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan), visibilitat);
			// El código del expediente debe ser válido
			if (dadesExpedientBDTO.getExpedientsRDTO() == null) {
				throw new GPAServeisServiceException(ErrorPrincipal.ERROR_EXPEDIENTS_NOT_FOUND.getDescripcio());
			}
			expedientConsultaRDTO = modelMapper.map(dadesExpedientBDTO, ExpedientConsultaRDTO.class);

			// Datos de cada tràmit OVT asociado a los documents aportats
			HashMap<String, es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO> tramitsOvtRDTOMap = null;
			es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = null;
			if (MapUtils.isNotEmpty(dadesExpedientBDTO.getTramitsOvtMap())) {
				tramitsOvtRDTOMap = new HashMap<String, es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO>();
				for (Entry<BigDecimal, TramitsOvtRDTO> tramitsOvtRDTOEntry : dadesExpedientBDTO.getTramitsOvtMap().entrySet()) {
					tramitsOvtRDTO = modelMapper.map(tramitsOvtRDTOEntry.getValue(),
					        es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);
					tramitsOvtRDTOMap.put(tramitsOvtRDTO.getCodi(), tramitsOvtRDTO);
				}
				if (CollectionUtils.isNotEmpty(expedientConsultaRDTO.getDocumentsAportats()) && MapUtils.isNotEmpty(tramitsOvtRDTOMap)) {
					for (DocumentAportatConsultaRDTO documentAportatConsultaRDTO : expedientConsultaRDTO.getDocumentsAportats()) {
						if (documentAportatConsultaRDTO.getTramit() != null) {
							documentAportatConsultaRDTO.setTramit(tramitsOvtRDTOMap.get(documentAportatConsultaRDTO.getTramit().getCodi()));
						}
					}
				}
			}

		} catch (GPAServeisServiceException e) {
			log.error("consultar(String)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_OBTENIR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			RespostaConsultaExpedientsBDTO respostaConsultaExpedientsBDTO = new RespostaConsultaExpedientsBDTO(
			        dadesExpedientBDTO != null ? expedientConsultaRDTO : null, respostaResultatBDTO);
			respostaConsultaExpedientsRDTO = modelMapper.map(respostaConsultaExpedientsBDTO, RespostaConsultaExpedientsRDTO.class);

			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/consultar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("GET");
			auditServeisBDTO.setValueAccio("Consultar les dades de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, null, respostaConsultaExpedientsBDTO, ex);
		}

		respostaConsultaExpedientsRDTO.setExpedient(expedientConsultaRDTO);

		if (log.isDebugEnabled()) {
			log.debug("consultar(String) - fi"); //$NON-NLS-1$
		}

		return respostaConsultaExpedientsRDTO;
	}

	/**
	 * Validar solicitud expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientValidacio
	 *            the expedient validacio
	 * @return the resposta validar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/validar")
	@ApiOperation(nickname = "validarSolicitudExpedientTramitadors", value = "Validar la sol·licitud de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaValidarExpedientRDTO validarSolicitudExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la validació de l'expedient") @RequestBody ExpedientValidacioRDTO expedientValidacio)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("validarSolicitudExpedient(String, ExpedientValidacioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaValidarExpedientRDTO respostaValidarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_VALIDAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_VALIDAR_EXPEDIENT);

			// Validar solicitud de expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.VALIDAR_SOLLICITUD, Resultat.ERROR_VALIDAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientValidacio.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.VALIDAR_SOLLICITUD.getInternalValue(),
			        dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			// debe existir una transicion posible para el estado actual
			ServeisRestControllerValidationHelper.validateTransicioAccioDisponibleExpedient(accionsEstatsRDTOList,
			        AccioTramitadorApiParamValue.VALIDAR_SOLLICITUD, Resultat.ERROR_VALIDAR_EXPEDIENT);

			expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

			ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());

			RespostaCanviarEstatAccioExpedient respostaCanviarEstatAccio = serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientValidacio.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.VALIDAR_SOLLICITUD.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

			RespostaExpedientsValidarBDTO respostaExpedientsValidarBDTO = new RespostaExpedientsValidarBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO(), respostaResultatBDTO);
			respostaValidarExpedientRDTO = modelMapper.map(respostaExpedientsValidarBDTO, RespostaValidarExpedientRDTO.class);

		} catch (GPAApiParamValidationException e) {
			log.error("validarSolicitudExpedient(String, ExpedientValidacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("validarSolicitudExpedient(String, ExpedientValidacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_VALIDAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/validar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Validar la sol·licitud de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientValidacio, respostaResultatBDTO, ex);
		}

		if (log.isDebugEnabled()) {
			log.debug("validarSolicitudExpedient(String, ExpedientValidacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaValidarExpedientRDTO;
	}

	/**
	 * Pausar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientPausa
	 *            the expedient pausa
	 * @return the resposta pausar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/pausar")
	@ApiOperation(nickname = "pausarExpedientTramitadors", value = "Pausar la tramitació de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaPausarExpedientRDTO pausarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la pausa de l'expedient", required = true) @RequestBody ExpedientPausaRDTO expedientPausa)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("pausarExpedient(String, String, ExpedientPausaRDTO) - inici");
			// $NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaPausarExpedientRDTO respostaPausarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PAUSAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_PAUSAR_EXPEDIENT);

			// Si se indica una fecha límite, debe ser posterior a la fecha
			// actual
			// ServeisRestControllerValidationHelper.validateDataLimit(expedientPausa.getDataLimit(),
			// Resultat.ERROR_PAUSAR_EXPEDIENT);

			// Pausar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.PAUSAR_EXPEDIENT, Resultat.ERROR_PAUSAR_EXPEDIENT);

			// Cambio de estado del expediente y actualización de fechas de
			// límite de plazo
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientPausa.getComentari());

			// obtenemos el idAccioEstat futuro
			// En este caso no realizamos consulta y utilizamos un
			// enum para determinar el idAccioEstat en funcion del motivo
			MotiuPausaApiParamValueTranslator motiuPausaApiParamValueTranslator = new MotiuPausaApiParamValueTranslator();
			MotiuPausaApiParamValue motiuPausaApiParamValue = motiuPausaApiParamValueTranslator
			        .getEnumByApiParamValue(expedientPausa.getMotiu());
			switch (motiuPausaApiParamValue) {
			case TRAMIT_ALLEGACIONS:
				expedientCanviEstat.setDiesTerminiAllegacio(expedientPausa.getDataLimit());
				expedientCanviEstat.setIdAccioEstat(
				        new BigDecimal(TransicioAccioEstatApiParamValue.PAUSAR_EXPEDIENT_PER_ALLEGACIO.getInternalValue()));
				break;
			case REQUERIMENT_SUBSANACIO:
				expedientCanviEstat.setDiesTerminiRequeriment(expedientPausa.getDataLimit());
				expedientCanviEstat
				        .setIdAccioEstat(new BigDecimal(TransicioAccioEstatApiParamValue.PAUSAR_EXPEDIENT_PER_ESMENES.getInternalValue()));
				break;
			case NOTIFICACIO_RESOLUCIO:
				expedientCanviEstat.setDiesTerminiRequeriment(expedientPausa.getDataLimit());
				break;
			case REQUERIMENT_INFORME:
				expedientCanviEstat.setDiesTerminiRequeriment(expedientPausa.getDataLimit());
				expedientCanviEstat
				        .setIdAccioEstat(new BigDecimal(TransicioAccioEstatApiParamValue.PAUSAR_EXPEDIENT_PER_INFORME.getInternalValue()));
				break;
			default:
				break;
			}

			ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());
			serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);

			// Se vuelve a consultar el expediente actualizado
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));

		} catch (GPAApiParamValidationException e) {
			log.error("pausarExpedient(String, String, ExpedientPausaRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("pausarExpedient(String, String, ExpedientPausaRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_PAUSAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/pausar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Pausar la tramitació de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientPausa, respostaResultatBDTO, ex);
		}

		RespostaExpedientsPausarBDTO respostaExpedientsPausarBDTO = new RespostaExpedientsPausarBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaPausarExpedientRDTO = modelMapper.map(respostaExpedientsPausarBDTO, RespostaPausarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("pausarExpedient(String, String, ExpedientPausaRDTO) - fi");
			// $NON-NLS-1$
		}

		return respostaPausarExpedientRDTO;
	}

	/**
	 * Reactivar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientReactivacio
	 *            the expedient reactivacio
	 * @return the resposta reactivar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/reactivar")
	@ApiOperation(nickname = "reactivarExpedientTramitadors", value = "Força la recuperació de l'expedient inclús abans que hagi transcorregut el termini", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaReactivarExpedientRDTO reactivarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la reactivació de l'expedient") @RequestBody ExpedientReactivacioRDTO expedientReactivacio)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("reactivarExpedient(String, ExpedientReactivacioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaReactivarExpedientRDTO respostaReactivarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REACTIVAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_REACTIVAR_EXPEDIENT);

			// Reactivar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.REACTIVAR_EXPEDIENT, Resultat.ERROR_REACTIVAR_EXPEDIENT);

			// Cambio de estado del expediente y actualización de fechas de
			// límite de plazo a null
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientReactivacio.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.REACTIVAR_EXPEDIENT.getInternalValue(),
			        dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			// debe existir una transicion posible para el estado actual
			ServeisRestControllerValidationHelper.validateTransicioAccioDisponibleExpedient(accionsEstatsRDTOList,
			        AccioTramitadorApiParamValue.REACTIVAR_EXPEDIENT, Resultat.ERROR_REACTIVAR_EXPEDIENT);

			expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

			ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());
			RespostaCanviarEstatAccioExpedient respostaCanviarEstatAccio = serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);

			RespostaExpedientsValidarBDTO respostaExpedientsValidarBDTO = new RespostaExpedientsValidarBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO(), respostaResultatBDTO);
			respostaReactivarExpedientRDTO = modelMapper.map(respostaExpedientsValidarBDTO, RespostaReactivarExpedientRDTO.class);

		} catch (GPAApiParamValidationException e) {
			log.error("reactivarExpedient(String, ExpedientReactivacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("reactivarExpedient(String, ExpedientReactivacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_REACTIVAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/reactivar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Força la recuperació de l'expedient inclús abans que hagi transcorregut el termini");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientReactivacio, respostaResultatBDTO, ex);
		}

		RespostaExpedientsReactivarBDTO respostaExpedientsReactivarBDTO = new RespostaExpedientsReactivarBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaReactivarExpedientRDTO = modelMapper.map(respostaExpedientsReactivarBDTO, RespostaReactivarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("reactivarExpedient(String, ExpedientReactivacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaReactivarExpedientRDTO;
	}

	/**
	 * Arxivar solicitud expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientArxiu
	 *            the expedient arxiu
	 * @return the resposta arxivar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/arxivar")
	@ApiOperation(nickname = "arxivarSolicitudExpedientTramitadors", value = Constants.DESCRIPCIO_ACCIO_ARXIVAR, tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaArxivarExpedientRDTO arxivarSolicitudExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de l'arxivat l'expedient") @RequestBody ExpedientArxiuRDTO expedientArxiu)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("arxivarSolicitudExpedient(String, ExpedientArxiuRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaArxivarExpedientRDTO respostaArxivarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ARXIVAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ARXIVAR_EXPEDIENT);

			// Archivar solicitud de expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.ARXIVAR_SOLLICITUD_INCOMPLETA, Resultat.ERROR_ARXIVAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientArxiu.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.ARXIVAR_SOLLICITUD_INCOMPLETA.getInternalValue(),
			        dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			// debe existir una transicion posible para el estado actual
			ServeisRestControllerValidationHelper.validateTransicioAccioDisponibleExpedient(accionsEstatsRDTOList,
			        AccioTramitadorApiParamValue.ARXIVAR_SOLLICITUD_INCOMPLETA, Resultat.ERROR_ARXIVAR_EXPEDIENT);

			expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

			ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());
			RespostaCanviarEstatAccioExpedient respostaCanviarEstatAccio = serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientArxiu.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(),
			        AccioTramitadorApiParamValue.ARXIVAR_SOLLICITUD_INCOMPLETA.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

			RespostaExpedientsArxivarBDTO respostaExpedientsArxivarBDTO = new RespostaExpedientsArxivarBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO(), respostaResultatBDTO);
			respostaArxivarExpedientRDTO = modelMapper.map(respostaExpedientsArxivarBDTO, RespostaArxivarExpedientRDTO.class);

		} catch (GPAApiParamValidationException e) {
			log.error("arxivarSolicitudExpedient(String, ExpedientArxiuRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("arxivarSolicitudExpedient(String, ExpedientArxiuRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ARXIVAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/artxivar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Arxivar sol·licitud incompleta");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientArxiu, respostaResultatBDTO, ex);
		}

		if (log.isDebugEnabled()) {
			log.debug("arxivarSolicitudExpedient(String, ExpedientArxiuRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaArxivarExpedientRDTO;
	}

	/**
	 * Retornar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientRetornRDTO
	 *            the expedient retorn
	 * @return the resposta retornar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/tramitar/retornar")
	@ApiOperation(nickname = "retornarExpedientTramitadors", value = "Donar resposta a l'acció Convidar a tramitar", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRetornarExpedientRDTO retornarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la tornada de l'expedient") @RequestBody ExpedientRetornRDTO expedientRetornRDTO)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("retornarExpedient(String, ExpedientRetornRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaRetornarExpedientRDTO respostaRetornarExpedientRDTO = null;
		RetornTramitacio retornTramitacio = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_RETORNAR_TRAMITACIO_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT);

			// Devolver la tramitación del expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.RETORNAR_TRAMITACIO, Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT);

			// Desasociar de la UG invitada a tramitar
			RetornarTramitacioRDTO retornarTramitacioRDTO = new RetornarTramitacioRDTO();
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(expedientRetornRDTO.getComentari());
			retornarTramitacioRDTO.setComentari(comentaris);

			// Cambio de estado del expediente en función del estado origen
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientRetornRDTO.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.RETORNAR_TRAMITACIO.getInternalValue(),
			        dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			ExpedientsRetornarTramitacioBDTO expedientsRetornarTramitacioBDTO = new ExpedientsRetornarTramitacioBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), retornarTramitacioRDTO);
			retornTramitacio = serveisService.retornarTramitacioExpedient(expedientsRetornarTramitacioBDTO);

			if (retornTramitacio != null && StringUtils.isEmpty(retornTramitacio.getMissatgeError())) {
				// Comprobamos si existe una transicion posible para el estado
				// actual y de ser así se cambia el estado al expediente
				boolean canviarEstat = ServeisRestControllerValidationHelper.validateCanviarEstatExpedient(accionsEstatsRDTOList,
				        AccioTramitadorApiParamValue.RETORNAR_TRAMITACIO, Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT);

				if (canviarEstat) {
					expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

					ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
					        dadesExpedientBDTO.getExpedientsRDTO().getId());
					serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);
				}
			}

		} catch (GPAApiParamValidationException e) {
			log.error("retornarExpedient(String, ExpedientRetornRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("retornarExpedient(String, ExpedientRetornRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/tramitar/retornar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Donar resposta a l'acció Convidar a tramitar");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientRetornRDTO, respostaResultatBDTO, ex);
		}

		if (retornTramitacio != null && StringUtils.isNotEmpty(retornTramitacio.getMissatgeError())) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setCodi(Constants.ERROR_STR);
			errorDTO.setDescripcio(retornTramitacio.getMissatgeError());

			ResultatRespostaDTO resultatRespostaDTO = new ResultatRespostaDTO();
			resultatRespostaDTO.setDetallError(errorDTO);

			respostaRetornarExpedientRDTO = new RespostaRetornarExpedientRDTO();
			respostaRetornarExpedientRDTO.setResultat(resultatRespostaDTO);
		} else {
			RespostaExpedientsRetornarBDTO respostaExpedientsRetornarBDTO = new RespostaExpedientsRetornarBDTO(
			        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
			respostaRetornarExpedientRDTO = modelMapper.map(respostaExpedientsRetornarBDTO, RespostaRetornarExpedientRDTO.class);
		}
		respostaRetornarExpedientRDTO.setRetornTramitacio(retornTramitacio);

		if (log.isDebugEnabled()) {
			log.debug("retornarExpedient(String, ExpedientRetornRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaRetornarExpedientRDTO;
	}

	/**
	 * Proposar resolucio expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientPropostaResolucio
	 *            the expedient proposta resolucio
	 * @return the resposta proposar resolucio expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/resolucio/proposar")
	@ApiOperation(nickname = "proposarResolucioExpedientTramitadors", value = "Eleva una proposta de resolució per sotmetre-la al vist-i-plau i signatura dels òrgans competents", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaProposarResolucioExpedientRDTO proposarResolucioExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la proposta de resolució de l'expedient") @RequestBody ExpedientPropostaResolucioRDTO expedientPropostaResolucio)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("proposarResolucioExpedient(String, ExpedientPropostaResolucioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaProposarResolucioExpedientRDTO respostaProposarResolucioExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PROPOSAR_RESOLUCIO_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_PROPOSAR_RESOLUCIO_EXPEDIENT);

			// Proponer la resolución del expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.PROPOSAR_RESOLUCIO, Resultat.ERROR_PROPOSAR_RESOLUCIO_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientPropostaResolucio.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.PROPOSAR_RESOLUCIO.getInternalValue(),
			        dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			// debe existir una transicion posible para el estado actual
			ServeisRestControllerValidationHelper.validateTransicioAccioDisponibleExpedient(accionsEstatsRDTOList,
			        AccioTramitadorApiParamValue.PROPOSAR_RESOLUCIO, Resultat.ERROR_PROPOSAR_RESOLUCIO_EXPEDIENT);

			expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

			ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());
			serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientPropostaResolucio.getComentari());
			comentariCreacioAccio.setOperacio(AccioTramitadorApiParamValue.PROPOSAR_RESOLUCIO.getApiParamValue());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.PROPOSAR_RESOLUCIO.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("proposarResolucioExpedient(String, ExpedientPropostaResolucioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("proposarResolucioExpedient(String, ExpedientPropostaResolucioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/resolucio/proposar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO
			        .setValueAccio("Eleva una proposta de resolució per sotmetre-la al vist-i-plau i signatura dels òrgans competents");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientPropostaResolucio, respostaResultatBDTO, ex);
		}

		RespostaExpedientsProposarResolucioBDTO respostaExpedientsProposarResolucioBDTO = new RespostaExpedientsProposarResolucioBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaProposarResolucioExpedientRDTO = modelMapper.map(respostaExpedientsProposarResolucioBDTO,
		        RespostaProposarResolucioExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("proposarResolucioExpedient(String, ExpedientPropostaResolucioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaProposarResolucioExpedientRDTO;
	}

	/**
	 * Tancar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientTancament
	 *            the expedient tancament
	 * @return the resposta tancar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/tancar")
	@ApiOperation(nickname = "tancarExpedientTramitadors", value = "Tancar l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaTancarExpedientRDTO tancarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades del tancament de l'expedient") @RequestBody ExpedientTancamentRDTO expedientTancament)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("tancarExpedient(String, ExpedientTancamentRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaTancarExpedientRDTO respostaTancarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_TANCAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_TANCAR_EXPEDIENT);

			// Cerrar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.TANCAR_EXPEDIENT, Resultat.ERROR_TANCAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientTancament.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.TANCAR_EXPEDIENT.getInternalValue(), dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			// debe existir una transicion posible para el estado actual
			ServeisRestControllerValidationHelper.validateTransicioAccioDisponibleExpedient(accionsEstatsRDTOList,
			        AccioTramitadorApiParamValue.TANCAR_EXPEDIENT, Resultat.ERROR_TANCAR_EXPEDIENT);

			expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

			ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());
			serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);

			// TODO Validar Contenido mínimo requerido (Documentos, Dades
			// d'Operació?)

		} catch (GPAApiParamValidationException e) {
			log.error("tancarExpedient(String, ExpedientTancamentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("tancarExpedient(String, ExpedientTancamentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_TANCAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/tancar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Tancar l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientTancament, respostaResultatBDTO, ex);
		}

		RespostaExpedientsTancarBDTO respostaExpedientsTancarBDTO = new RespostaExpedientsTancarBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaTancarExpedientRDTO = modelMapper.map(respostaExpedientsTancarBDTO, RespostaTancarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("tancarExpedient(String, ExpedientTancamentRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaTancarExpedientRDTO;
	}

	/**
	 * Tornar enrere expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientTornadaEnrere
	 *            the expedient tornada enrere
	 * @return the resposta tornar enrere expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/tornar")
	@ApiOperation(nickname = "tornarEnrereExpedientTramitadors", value = "Tornar enrere", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaTornarEnrereExpedientRDTO tornarEnrereExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades del tancament de l'expedient") @RequestBody ExpedientTornadaEnrereRDTO expedientTornadaEnrere)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("tornarEnrereExpedient(String, ExpedientTornadaEnrereRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaTornarEnrereExpedientRDTO respostaTornarEnrereExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_TORNAR_ENRERE_EXPEDIENT);
		try {

			// desde tramitadors no se controla la visibilidad, solo afecta a
			// portal
			BigDecimal visibilitat = BigDecimal.ONE;

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan), visibilitat);
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_TORNAR_ENRERE_EXPEDIENT);

			// Volver atrás si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioTornarEnrereDisponibleExpedient(
			        dadesExpedientBDTO.getExpedientsRDTO().getIdEstat(), Resultat.ERROR_TORNAR_ENRERE_EXPEDIENT);

			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(expedientTornadaEnrere.getComentari());

			TornarEnrereRDTO tornarEnrereRDTO = new TornarEnrereRDTO();
			tornarEnrereRDTO.setComentari(comentaris);

			ExpedientsTornarEnrereBDTO expedientsTornarEnrereBDTO = new ExpedientsTornarEnrereBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), tornarEnrereRDTO);

			serveisService.tornarEnrereExpedient(expedientsTornarEnrereBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("tornarEnrereExpedient(String, ExpedientTornadaEnrereRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("tornarEnrereExpedient(String, ExpedientTornadaEnrereRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_TORNAR_ENRERE_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/tornar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Tornar enrere");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientTornadaEnrere, respostaResultatBDTO, ex);
		}

		RespostaExpedientsTornarEnrereBDTO respostaExpedientsTornarEnrereBDTO = new RespostaExpedientsTornarEnrereBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaTornarEnrereExpedientRDTO = modelMapper.map(respostaExpedientsTornarEnrereBDTO, RespostaTornarEnrereExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("tornarEnrereExpedient(String, ExpedientTornadaEnrereRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaTornarEnrereExpedientRDTO;
	}

	/**
	 * Validar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param documentAportatValidar
	 *            the document aportat validar
	 * @return the resposta validar document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/validar")
	@ApiOperation(nickname = "validarDocumentExpedientTramitadors", value = "Validar document de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaValidarDocumentRDTO validarDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Dades de la versió del document") @RequestBody DocumentAportatValidarRDTO documentAportatValidar)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("validarDocumentExpedient(String, BigDecimal, DocumentAportatValidarRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaValidarDocumentRDTO respostaValidarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_VALIDAR_DOCUMENT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_VALIDAR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO.getExpedientsRDTO(),
			        Resultat.ERROR_VALIDAR_DOCUMENT_EXPEDIENT);

			// Validar documento si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.VALIDAR_DOCUMENT, Resultat.ERROR_VALIDAR_DOCUMENT_EXPEDIENT);

			// Estado de revisión del documento a Correcte
			DocumentRevisio documentRevisio = new DocumentRevisio();
			documentRevisio.setDocsEntradaIds(Arrays.asList(idDocument));
			documentRevisio.setExpedientId(dadesExpedientBDTO.getExpedientsRDTO().getId());
			documentRevisio.setEstatRevisioId(RevisioApiParamValue.CORRECTE.getInternalValue());
			DocumentAportatValidarBDTO documentAportatValidarBDTO = new DocumentAportatValidarBDTO(documentRevisio);
			serveisService.revisarDocumentacioEntrada(documentAportatValidarBDTO);

			// Si todo fue bien, se actualiza el valor en el objeto utilizado
			// para construir la salida
			docsEntradaRDTO.setRevisio(RevisioApiParamValue.CORRECTE.getInternalValue());

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(documentAportatValidar.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.VALIDAR_DOCUMENT.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("validarDocumentExpedient(String, BigDecimal, DocumentAportatValidarRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("validarDocumentExpedient(String, BigDecimal, DocumentAportatValidarRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_VALIDAR_DOCUMENT_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/" + idDocument + "/validar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Validar document de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, documentAportatValidar, respostaResultatBDTO, ex);
		}

		RespostaValidarDocumentExpedientBDTO respostaValidarDocumentExpedientBDTO = new RespostaValidarDocumentExpedientBDTO(
		        docsEntradaRDTO, respostaResultatBDTO);
		respostaValidarDocumentRDTO = modelMapper.map(respostaValidarDocumentExpedientBDTO, RespostaValidarDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("validarDocumentExpedient(String, BigDecimal, DocumentAportatValidarRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaValidarDocumentRDTO;
	}

	/**
	 * Rebutjar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param documentAportatRebutjar
	 *            the document aportat rebutjar
	 * @return the resposta rebutjar document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/rebutjar")
	@ApiOperation(nickname = "rebutjarDocumentExpedientTramitadors", value = "Rebutjar document de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRebutjarDocumentRDTO rebutjarDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Dades de la versió del document") @RequestBody DocumentAportatRebutjarRDTO documentAportatRebutjar)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("rebutjarDocumentExpedient(String, BigDecimal, DocumentAportatRebutjarRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaRebutjarDocumentRDTO respostaRebutjarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REBUTJAR_DOCUMENT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_REBUTJAR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO.getExpedientsRDTO(),
			        Resultat.ERROR_REBUTJAR_DOCUMENT_EXPEDIENT);

			// Validar documento si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.REBUTJAR_DOCUMENT, Resultat.ERROR_REBUTJAR_DOCUMENT_EXPEDIENT);

			// Estado de revisión del documento a Incorrecte
			DocumentRevisio documentRevisio = new DocumentRevisio();
			documentRevisio.setDocsEntradaIds(Arrays.asList(idDocument));
			documentRevisio.setExpedientId(dadesExpedientBDTO.getExpedientsRDTO().getId());
			documentRevisio.setEstatRevisioId(RevisioApiParamValue.INCORRECTE.getInternalValue());
			DocumentAportatValidarBDTO documentAportatValidarBDTO = new DocumentAportatValidarBDTO(documentRevisio);
			serveisService.revisarDocumentacioEntrada(documentAportatValidarBDTO);

			// Si todo fue bien, se actualiza el valor en el objeto utilizado
			// para construir la salida
			docsEntradaRDTO.setRevisio(RevisioApiParamValue.INCORRECTE.getInternalValue());

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(documentAportatRebutjar.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.REBUTJAR_DOCUMENT.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("rebutjarDocumentExpedient(String, BigDecimal, DocumentAportatRebutjarRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("rebutjarDocumentExpedient(String, BigDecimal, DocumentAportatRebutjarRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_REBUTJAR_DOCUMENT_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/" + idDocument + "/rebutjar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Rebutjar document de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, documentAportatRebutjar, respostaResultatBDTO, ex);
		}

		RespostaRebutjarDocumentExpedientBDTO respostaRebutjarDocumentExpedientBDTO = new RespostaRebutjarDocumentExpedientBDTO(
		        docsEntradaRDTO, respostaResultatBDTO);
		respostaRebutjarDocumentRDTO = modelMapper.map(respostaRebutjarDocumentExpedientBDTO, RespostaRebutjarDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("rebutjarDocumentExpedient(String, BigDecimal, DocumentAportatRebutjarRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaRebutjarDocumentRDTO;
	}

	/**
	 * Convidar tramitar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientConvidarTramitarRDTO
	 *            the expedient convidar tramitar
	 * @return the resposta convidar tramitar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/tramitar/convidar")
	@ApiOperation(nickname = "convidarTramitarExpedientTramitadors", value = "Convidar a tramitar l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaConvidarTramitarExpedientRDTO convidarTramitarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la invitació a tramitar l'expedient") @RequestBody ExpedientConvidarTramitarRDTO expedientConvidarTramitarRDTO)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("convidarTramitarExpedient(String, ExpedientConvidarTramitarRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaConvidarTramitarExpedientRDTO respostaConvidarTramitarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_CONVIDAR_TRAMITAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

			// Se obtiene la información del procedimiento asociado al
			// expediente
			DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
			        .consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

			// El codi de la unitat gestora debe existir y estar vigente
			UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = null;
			UnitatsGestoresRDTO unitatsGestoresRDTO = null;
			List<UnitatsGestoresRDTO> llistaUnitatsGestoresRDTO = new ArrayList<>();
			for (String codUnitatGestora : expedientConvidarTramitarRDTO.getCodiUnitatGestoraList()) {
				unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(codUnitatGestora);
				unitatsGestoresRDTO = serveisService.consultarDadesUnitatGestora(unitatsGestoresCercaBDTO);
				ServeisRestControllerValidationHelper.validateUnitatGestora(unitatsGestoresRDTO, dadesProcedimentBDTO,
				        Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

				// La UG convidada debe ser diferente a la UG principal
				ServeisRestControllerValidationHelper.validateUnitatGestoraConvidada(unitatsGestoresRDTO.getId(),
				        dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext(), Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

				// metermos en una lista unitatsGestoresRDTO
				llistaUnitatsGestoresRDTO.add(unitatsGestoresRDTO);
			}

			// las unidades convidadas que vengan no pueden ya existir para el
			// expediente
			ServeisRestControllerValidationHelper.validateNoExistUnitatGestoraConvidada(expedientConvidarTramitarRDTO, dadesExpedientBDTO,
			        Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

			// Invitar a tramitar el expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.CONVIDAR_TRAMITAR, Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

			// Asociación de la UG invitada a tramitar
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(expedientConvidarTramitarRDTO.getComentari());

			DropdownItemBDTO dropdownItemBDTO = null;
			List<DropdownItemBDTO> llistaDropdownItemBDTO = new ArrayList<>();
			for (UnitatsGestoresRDTO unitatGestorRDTO : llistaUnitatsGestoresRDTO) {
				dropdownItemBDTO = new DropdownItemBDTO();

				dropdownItemBDTO.setId(unitatGestorRDTO.getId());
				dropdownItemBDTO.setDescripcio(unitatGestorRDTO.getDescripcio());

				llistaDropdownItemBDTO.add(dropdownItemBDTO);
			}

			ConvidarTramitarRDTO convidarTramitarRDTO = new ConvidarTramitarRDTO();
			convidarTramitarRDTO.setComentari(comentaris);
			// TODO GPA-2901
			// convidarTramitarRDTO.setUnitatGestoraConvidada(dropdownItemBDTO);
			convidarTramitarRDTO.setCodiUnitatGestoraList(llistaDropdownItemBDTO);

			// Cambio de estado del expediente en función del estado origen
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientConvidarTramitarRDTO.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.CONVIDAR_TRAMITAR.getInternalValue(), dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			// Comprobamos si existe una transicion posible para el estado
			// actual y de ser así se cambia el estado al expediente
			boolean canviarEstat = ServeisRestControllerValidationHelper.validateCanviarEstatExpedient(accionsEstatsRDTOList,
			        AccioTramitadorApiParamValue.CONVIDAR_TRAMITAR, Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

			if (canviarEstat) {
				expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

				ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
				        dadesExpedientBDTO.getExpedientsRDTO().getId());
				serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);
			}

			ExpedientsConvidarTramitarBDTO expedientsConvidarTramitarBDTO = new ExpedientsConvidarTramitarBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), convidarTramitarRDTO);
			serveisService.convidarTramitarExpedient(expedientsConvidarTramitarBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("convidarTramitarExpedient(String, ExpedientConvidarTramitarRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("convidarTramitarExpedient(String, ExpedientConvidarTramitarRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/tramitar/convidar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Convidar a tramitar l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientConvidarTramitarRDTO, respostaResultatBDTO, ex);
		}

		RespostaExpedientsConvidarTramitarBDTO respostaExpedientsConvidarTramitarBDTO = new RespostaExpedientsConvidarTramitarBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaConvidarTramitarExpedientRDTO = modelMapper.map(respostaExpedientsConvidarTramitarBDTO,
		        RespostaConvidarTramitarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("convidarTramitarExpedient(String, ExpedientConvidarTramitarRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaConvidarTramitarExpedientRDTO;
	}

	/**
	 * Canviar unitat gestora expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientCanviUnitatGestora
	 *            the expedient canvi unitat gestora
	 * @return the resposta canviar unitat gestora expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/unitat")
	@ApiOperation(nickname = "canviarUnitatGestoraExpedientTramitadors", value = "Canviar la unitat gestora de l’expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaCanviarUnitatGestoraExpedientRDTO canviarUnitatGestoraExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la versió del document") @RequestBody ExpedientCanviUnitatGestoraRDTO expedientCanviUnitatGestora)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("canviarUnitatGestoraExpedient(String, ExpedientCanviUnitatGestoraRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaCanviarUnitatGestoraExpedientRDTO respostaCanviarUnitatGestoraExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		UnitatsGestoresRDTO unitatsGestoresRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_CANVIAR_UNITAT_GESTORA_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT);

			// Se obtiene la información del procedimiento asociado al
			// expediente
			DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
			        .consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

			// El codi de la nueva unitat gestora debe existir, estar vigente y
			// asociada al Procedimiento del Expediente
			UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(
			        expedientCanviUnitatGestora.getCodiUnitatGestora());
			unitatsGestoresRDTO = serveisService.consultarDadesUnitatGestora(unitatsGestoresCercaBDTO);
			ServeisRestControllerValidationHelper.validateUnitatGestora(unitatsGestoresRDTO, dadesProcedimentBDTO,
			        Resultat.ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT);
			// Se setea la nueva unidad gestora en la información del expediente
			dadesExpedientBDTO.setUnitatsGestoresRDTO(unitatsGestoresRDTO);

			// Cambiar la Unidad Gestora del expediente si la acción es
			// permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.CANVIAR_UNITAT_GESTORA, Resultat.ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT);

			// Redirección del Asiento de Registro
			RedireccioAssentament redireccioAssentament = new RedireccioAssentament();
			redireccioAssentament.setCodiUnitatGestora(unitatsGestoresRDTO.getNom());
			redireccioAssentament
			        .setNumeroAssentament(dadesExpedientBDTO.getExpedientsRDTO().getSollicituds().getRegistreAssentament().getCodi());
			ExpedientsRedireccionarAssentamentBDTO expedientsRedireccionarAssentamentBDTO = new ExpedientsRedireccionarAssentamentBDTO(
			        redireccioAssentament);
			serveisService.redireccionarRegistre(expedientsRedireccionarAssentamentBDTO);

			// Asociación de la nueva UG
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(expedientCanviUnitatGestora.getComentari());

			DropdownItemBDTO unitatGestoraActual = new DropdownItemBDTO();
			unitatGestoraActual.setId(dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());
			unitatGestoraActual.setDescripcio(dadesExpedientBDTO.getExpedientsRDTO().getDescUnitatGestora());

			DropdownItemBDTO unitatGestoraFutura = new DropdownItemBDTO();
			unitatGestoraFutura.setId(unitatsGestoresRDTO.getId());
			unitatGestoraFutura.setDescripcio(unitatsGestoresRDTO.getDescripcio());

			CanviUnitatGestoraRDTO canviUnitatGestoraRDTO = new CanviUnitatGestoraRDTO();
			canviUnitatGestoraRDTO.setComentari(comentaris);
			canviUnitatGestoraRDTO.setUnitatGestoraActual(unitatGestoraActual);
			canviUnitatGestoraRDTO.setUnitatGestoraFutura(unitatGestoraFutura);

			ExpedientsCanviarUnitatGestoraBDTO expedientsCanviarUnitatGestoraBDTO = new ExpedientsCanviarUnitatGestoraBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), canviUnitatGestoraRDTO);
			serveisService.canviarUnitatGestoraExpedient(expedientsCanviarUnitatGestoraBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("canviarUnitatGestoraExpedient(String, ExpedientCanviUnitatGestoraRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("canviarUnitatGestoraExpedient(String, ExpedientCanviUnitatGestoraRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT,
			        e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/unitat");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Canviar la unitat gestora de l’expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientCanviUnitatGestora, respostaResultatBDTO, ex);
		}

		RespostaExpedientsCanviarUnitatGestoraBDTO respostaExpedientsCanviarUnitatGestoraBDTO = new RespostaExpedientsCanviarUnitatGestoraBDTO(
		        dadesExpedientBDTO, respostaResultatBDTO);
		respostaCanviarUnitatGestoraExpedientRDTO = modelMapper.map(respostaExpedientsCanviarUnitatGestoraBDTO,
		        RespostaCanviarUnitatGestoraExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("canviarUnitatGestoraExpedient(String, ExpedientCanviUnitatGestoraRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaCanviarUnitatGestoraExpedientRDTO;
	}

	/**
	 * Incorporar nou document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param file
	 *            the file
	 * @param documentIncorporacioNou
	 *            the document incorporacio nou
	 * @return the resposta incorporar nou document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping(value = "/expedients/{codiExpedient}/documentacio", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(nickname = "incorporarNouDocumentExpedientTramitadors", value = "Incorporar un nou document electrònic", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	@ApiImplicitParams(@ApiImplicitParam(name = "document", value = "Dades del document a incorporar", dataType = "string", paramType = "form", required = true))
	public RespostaIncorporarNouDocumentRDTO incorporarNouDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Fitxer") @RequestParam(value = "file", required = false) MultipartFile file,
	        @RequestParam("document") DocumentIncorporacioNouRDTO documentIncorporacioNou) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaIncorporarNouDocumentRDTO respostaIncorporarNouDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RegistreAssentamentRDTO registreAssentamentRDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		DocsTramitacioRDTO docsTramitacioRDTOResult = null;
		Boolean esAportada = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);
		GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO = null;

		try {
			ConfiguracioApiParamValueTranslator configuracioApiParamValueTranslator = new ConfiguracioApiParamValueTranslator();
			ConfiguracioApiParamValue configuracioApiParamValue = configuracioApiParamValueTranslator
			        .getEnumByApiParamValue(documentIncorporacioNou.getDocument().getConfiguracio());
			switch (configuracioApiParamValue) {
			case APORTADA:
				esAportada = Boolean.TRUE;

				break;
			case GENERADA:
				esAportada = Boolean.FALSE;

				break;
			default:
				break;
			}

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

			if (esAportada) {
				// El número de registro indicado debe existir
				registreAssentamentRDTO = serveisService
				        .consultarDadesRegistreAssentament(documentIncorporacioNou.getDocument().getNumeroRegistre());
				ServeisRestControllerValidationHelper.validateRegistreAssentament(registreAssentamentRDTO,
				        Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);
			}

			// Incorporar un nuevo documento electrónico al expediente si la
			// acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.INCORPORAR_NOU_DOCUMENT_ELECTRONIC, Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

			// Incorporar un nuevo documento, pudiéndose tratar de entrada o
			// tramitación
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			if (BooleanUtils.isTrue(esAportada)) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
				HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioEntradaIncorporatNou(
				                respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
				                documentIncorporacioNou.getDocument(), Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentIncorporacioNou.getDocument(), DocsEntradaRDTO.class);
				docsEntradaRDTO
				        .setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());

				if (registreAssentamentRDTO != null) {
					RegistreAssentament registreAssentament = new RegistreAssentament();
					registreAssentament.setId(registreAssentamentRDTO.getId());
					docsEntradaRDTO.setRegistreAssentament(registreAssentament);
				}

				guardarDocumentEntradaFitxerBDTO = new GuardarDocumentEntradaFitxerBDTO(dadesExpedientBDTO.getExpedientsRDTO().getId(),
				        docsEntradaRDTO, file, null);
				docsEntradaRDTOResult = serveisService.guardarDocumentEntradaFitxer(guardarDocumentEntradaFitxerBDTO);
			} else {
				DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
				RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
				HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioTramitacioIncorporatNou(
				                respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
				                documentIncorporacioNou.getDocument(), Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(documentIncorporacioNou.getDocument(), DocsTramitacioRDTO.class);
				docsTramitacioRDTO.setConfigDocTramitacio(
				        configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());

				if (documentIncorporacioNou.getDocument().getPlantillaPdf()) {
					ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
					configuracioDocsTramitacio.setSuportEnllac(configuracioDocsTramitacioMap
					        .get(documentIncorporacioNou.getDocument().getConfiguracioDocumentacio()).getSuportEnllac());
					docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);

					CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO = new CrearDocumentTramitacioBDTO(
					        dadesExpedientBDTO.getExpedientsRDTO().getId(), dadesExpedientBDTO.getExpedientsRDTO().getSollicitud(),
					        docsTramitacioRDTO);
					docsTramitacioRDTOResult = serveisService.guardarDocumentTramitacioPlantilla(crearDocumentTramitacioBDTO);
				} else {
					GuardarDocumentTramitacioFitxerBDTO guardarDocumentTramitacioFitxerBDTO = new GuardarDocumentTramitacioFitxerBDTO(
					        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsTramitacioRDTO, file);
					docsTramitacioRDTOResult = serveisService.guardarDocumentTramitacioFitxer(guardarDocumentTramitacioFitxerBDTO);
				}
			}

		} catch (GPAApiParamValidationException e) {
			log.error("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT,
			        e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Incorporar un nou document electrònic");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, documentIncorporacioNou, respostaResultatBDTO, ex);
		}

		if (BooleanUtils.isTrue(esAportada)) {
			RespostaIncorporarNouDocumentEntradaExpedientBDTO respostaIncorporarNouDocumentEntradaExpedientBDTO = new RespostaIncorporarNouDocumentEntradaExpedientBDTO(
			        docsEntradaRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
			        registreAssentamentRDTO, respostaResultatBDTO);
			respostaIncorporarNouDocumentRDTO = modelMapper.map(respostaIncorporarNouDocumentEntradaExpedientBDTO,
			        RespostaIncorporarNouDocumentRDTO.class);
		} else {
			RespostaIncorporarNouDocumentTramitacioExpedientBDTO respostaIncorporarNouDocumentTramitacioExpedientBDTO = new RespostaIncorporarNouDocumentTramitacioExpedientBDTO(
			        docsTramitacioRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
			        respostaResultatBDTO);
			respostaIncorporarNouDocumentRDTO = modelMapper.map(respostaIncorporarNouDocumentTramitacioExpedientBDTO,
			        RespostaIncorporarNouDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaIncorporarNouDocumentRDTO;
	}

	/**
	 * Validar resolucio document.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocResolucio
	 *            the id doc resolucio
	 * @param persona
	 *            the persona
	 * @return the resposta resolucio validar document RDTO
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/expedients/{codiExpedient}/resolucio/{idDocResolucio}/validar")
	@ApiOperation(nickname = "validarResolucioDocumentTramitadors", value = "Validar un document", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaResolucioValidarDocumentRDTO validarResolucioDocument(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocResolucio,
	        @ApiParam(value = "Informació addicional per a la signatura", required = true) @RequestBody SignaturaDocumentRDTO signaturaDocument)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("validarResolucioDocument(String, BigDecimal, PersonaValidarResolucioDocumentRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaResolucioValidarDocumentRDTO respostaResolucioValidarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_VALIDAR_DOCUMENT);
		PeticionsPortasig peticionsPortasig = null;
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_VALIDAR_DOCUMENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocResolucio);
			ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
			        Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

			// Registrar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.VALIDAR_DOCUMENT, Resultat.ERROR_VALIDAR_DOCUMENT);

			// El usuario indicado debe existir
			UsuarisRDTO usuarisRDTO = serveisService.consultarDadesUsuari(signaturaDocument.getUsuariPortasig().getMatricula());
			ServeisRestControllerValidationHelper.validateUsuari(usuarisRDTO, Resultat.ERROR_VALIDAR_DOCUMENT);

			// Validar documento
			UnitatsOrganigramaRDTO unitatsOrganigramaRDTO = serveisService
			        .consultarDadesUnitatOrganigrama(dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());

			SignarPortasignaturesDocument signarPortasignaturesDocument = new SignarPortasignaturesDocument();
			signarPortasignaturesDocument.setIdDocument(idDocResolucio);
			signarPortasignaturesDocument.setAccio(TipusAccionsPortaSigApiParamValue.VALIDAR_DOCUMENT.getInternalValue());
			signarPortasignaturesDocument.setCodiUnitatOrganigrama(unitatsOrganigramaRDTO.getCodi());
			signarPortasignaturesDocument.setMatriculaUsuari(usuarisRDTO.getMatricula());
			signarPortasignaturesDocument.setNomProcediment(dadesExpedientBDTO.getExpedientsRDTO().getNomProcediment());
			signarPortasignaturesDocument.setPoliticaSignatura(signaturaDocument.getPoliticaSignatura());

			peticionsPortasig = serveisService.signarValidarDocument(signarPortasignaturesDocument);

		} catch (GPAApiParamValidationException e) {
			log.error("validarResolucioDocument(String, BigDecimal, PersonaValidarResolucioDocumentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("validarResolucioDocument(String, BigDecimal, PersonaValidarResolucioDocumentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_VALIDAR_DOCUMENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/resolucio/" + idDocResolucio + "/validar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Validar un document");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, signaturaDocument, respostaResultatBDTO, ex);
		}

		if (peticionsPortasig != null && peticionsPortasig.getCodiError() != null) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setCodi(peticionsPortasig.getCodiError());
			errorDTO.setDescripcio(peticionsPortasig.getMissatgeError());

			ResultatRespostaDTO resultatRespostaDTO = new ResultatRespostaDTO();
			resultatRespostaDTO.setDetallError(errorDTO);

			respostaResolucioValidarDocumentRDTO = new RespostaResolucioValidarDocumentRDTO();
			respostaResolucioValidarDocumentRDTO.setResultat(resultatRespostaDTO);
		} else {
			RespostaResolucioValidarDocumentBDTO respostaResolucioValidarDocumentBDTO = new RespostaResolucioValidarDocumentBDTO(
			        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
			respostaResolucioValidarDocumentRDTO = modelMapper.map(respostaResolucioValidarDocumentBDTO,
			        RespostaResolucioValidarDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("validarResolucioDocument(String, BigDecimal, PersonaValidarResolucioDocumentRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaResolucioValidarDocumentRDTO;
	}

	/**
	 * Signar document.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param persona
	 *            the persona
	 * @return the resposta signar document RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/signar")
	@ApiOperation(nickname = "signarDocumentTramitadors", value = "Signar un document", tags = { "Serveis Tramitadors API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaSignarDocumentRDTO signarDocument(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Informació addicional per a la signatura", required = true) @RequestBody SignaturaDocumentRDTO signaturaDocument)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("signarDocument(String, BigDecimal, UsuariPortaSigRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		ImiUserDetails imiUser = SecurityUtils.getLoggedUserDetails();
		String userInfo = imiUser != null ? imiUser.getPayload() : "Sin usuario";
		if (log.isInfoEnabled()) {
			log.info("SEGUIMIENTO USUARIO SSO signarDocument (RestController): " + userInfo);
		}

		RespostaSignarDocumentRDTO respostaSignarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_SIGNAR_DOCUMENT);
		PeticionsPortasig peticionsPortasig = null;
		boolean signat = false;
		try {

			// La política de signatura de los documentos debe estar rellena
			ServeisRestControllerValidationHelper.validateDocumentPoliticaSignatura(signaturaDocument.getPoliticaSignatura(),
			        Resultat.ERROR_SIGNAR_DOCUMENT);

			// El codi del expediente debe existir
			if (StringUtils.equals(signaturaDocument.getModalitatSignatura(), TipusSignaturaApiParamValue.MANUSCRITA.getApiParamValue())) {
				dadesExpedientBDTO = serveisService.consultarDadesExpedient(
				        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan),
				        ServeisRestControllerVisibilitatHelper.obtenirVisibilitatExpedient(serveisService, codiExpedient,
				                expedientsIdOrgan));
				ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_SIGNAR_DOCUMENT);
			} else {
				dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
				        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
				ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_SIGNAR_DOCUMENT);
			}

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
			        Resultat.ERROR_SIGNAR_DOCUMENT);

			// Comprobar si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.SIGNAR_DOCUMENT, Resultat.ERROR_SIGNAR_DOCUMENT);

			// Diferenciar los tipos de firma, para mantener comportamiento
			// anterior, si no viene tipo, se realiza la llamada a portasig
			TipusSignaturaApiParamValueTranslator tipusSignaturaApiParamValueTranslator = new TipusSignaturaApiParamValueTranslator();
			TipusSignaturaApiParamValue tipusSignaturaApiParamValue = tipusSignaturaApiParamValueTranslator
			        .getEnumByApiParamValue(signaturaDocument.getModalitatSignatura());

			// se realizaran 10 intentos de firma si hay fallo, 9 en bucle para
			// relanzar y el ultimo fuera para finalizar el ciclo
			// De acuerdo a la indisponibilidad del último documento firmado en
			// el gestor documental dentro de una secuencia de firma, se acuerda
			// incluir 10 reintentos con un intervalo de 1 minuto entre cada uno
			for (int i = 0; i < 9 && !signat; i++) {
				try {
					peticionsPortasig = processarSignatura(idDocument, signaturaDocument, dadesExpedientBDTO, peticionsPortasig,
					        tipusSignaturaApiParamValue);

					signat = true;

				} catch (Exception e) {
					log.error("signarDocument(String, BigDecimal, UsuariPortaSigRDTO)", e); // $NON-NLS-1$

					serveisService.incrementarReintentsSignatura(idDocument);

					// Se duerme el hilo durante 1 minuto antes del siguiente
					// reintento para dar tiempo a que el documento firmado se
					// vuelque al gestor documental
					TimeUnit.MINUTES.sleep(1);
				}
			}

			if (!signat) {
				peticionsPortasig = processarSignatura(idDocument, signaturaDocument, dadesExpedientBDTO, peticionsPortasig,
				        tipusSignaturaApiParamValue);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("signarDocument(String, BigDecimal, PersonaSignarDocumentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("signarDocument(String, BigDecimal, PersonaSignarDocumentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_SIGNAR_DOCUMENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/resolucio/" + idDocument + "/signar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Validar un document");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, signaturaDocument, respostaResultatBDTO, ex);
		}

		if (peticionsPortasig != null && peticionsPortasig.getCodiError() != null) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setCodi(peticionsPortasig.getCodiError());
			errorDTO.setDescripcio(peticionsPortasig.getMissatgeError());

			ResultatRespostaDTO resultatRespostaDTO = new ResultatRespostaDTO();
			resultatRespostaDTO.setDetallError(errorDTO);

			respostaSignarDocumentRDTO = new RespostaSignarDocumentRDTO();
			respostaSignarDocumentRDTO.setResultat(resultatRespostaDTO);
		} else {
			RespostaSignarDocumentBDTO respostaSignarDocumentBDTO = new RespostaSignarDocumentBDTO(
			        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
			respostaSignarDocumentRDTO = modelMapper.map(respostaSignarDocumentBDTO, RespostaSignarDocumentRDTO.class);
		}
		if (log.isDebugEnabled()) {
			log.debug("signarDocument(String, BigDecimal, UsuariPortaSigRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaSignarDocumentRDTO;
	}

	/**
	 * Finalitzar signar manuscrita.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @return the resposta finalitzar signar manuscrita document RDTO
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/signar/manuscrita/finalitzar")
	@ApiOperation(nickname = "finalitzarSignarManuscritaTramitadors", value = "Finalitzar una petició de signatura manuscrita", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaFinalitzarSignarManuscritaDocumentRDTO finalitzarSignarManuscrita(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("finalitzarSignarManuscrita() - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaFinalitzarSignarManuscritaDocumentRDTO respostaFinalitzarSignarManuscritaDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_SIGNAR_DOCUMENT);

		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_SIGNAR_DOCUMENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
			        Resultat.ERROR_SIGNAR_DOCUMENT);

			// la modalidad de firma pendiente del documento debe ser Manuscrita
			ServeisRestControllerValidationHelper.validateSeguentSignaturaManuscrita(docsTramitacioRDTO, Resultat.ERROR_SIGNAR_DOCUMENT);

			// Se lanza una validación que compruebe si la petición
			// contiene documentos firmados
			String idPeticio = docsTramitacioRDTO.getDocsSignaturesPendents().get(0).getTicketPeticio().toString();
			ServeisRestControllerValidationHelper.validatePeticioAmbDocumentsSignats(serveisService.peticioAmbDocumentsSignats(idPeticio),
			        Resultat.ERROR_SIGNAR_DOCUMENT);

			// Si la petición contiene documentos firmados se procede con la
			// finalización del proceso de firma
			serveisService.finalitzarSignaturaTablet(idPeticio);

		} catch (GPAApiParamValidationException e) {
			log.error("finalitzarSignarManuscrita()", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("finalitzarSignarManuscrita()", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_SIGNAR_DOCUMENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO
			        .setMappingAccio("/expedients/" + codiExpedient + "/documentacio/" + idDocument + "/signar/manuscrita/finalitzar/");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Finalitzar una petició de signatura manuscrita");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, null, respostaResultatBDTO, ex);
		}

		RespostaFinalitzarSignarManuscritaDocumentBDTO respostaFinalitzarSignarManuscritaDocumentBDTO = new RespostaFinalitzarSignarManuscritaDocumentBDTO(
		        respostaResultatBDTO);
		respostaFinalitzarSignarManuscritaDocumentRDTO = modelMapper.map(respostaFinalitzarSignarManuscritaDocumentBDTO,
		        RespostaFinalitzarSignarManuscritaDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("finalitzarSignarManuscrita() - fi"); //$NON-NLS-1$
		}

		return respostaFinalitzarSignarManuscritaDocumentRDTO;
	}

	/**
	 * Signar document online.
	 *
	 * @param idsDocument
	 *            the ids document
	 * @param signaturaValidDocument
	 *            the signatura valid document
	 * @return the resposta signar document RDTO
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/expedients/documentacio/{idsDocument}/signar/online")
	@ApiOperation(nickname = "signarDocumentOnlineTramitadors", value = "Signar un document en línia", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaSignarDocumentRDTO signarDocumentOnline(
	        @ApiParam(value = "Identificadors dels documents", required = true) @PathVariable BigDecimal[] idsDocument,
	        @ApiParam(value = "Informació addicional per a la signatura", required = true) @RequestBody SignaturaValidDocumentRDTO signaturaValidDocument)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("signarDocumentOnline(BigDecimal[], SignaturaValidDocumentRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaSignarDocumentRDTO respostaSignarDocumentRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_SIGNAR_DOCUMENT);
		try {
			// La política de signatura de los documentos debe estar rellena
			ServeisRestControllerValidationHelper.validateDocumentPoliticaSignatura(signaturaValidDocument.getPoliticaSignatura(),
			        Resultat.ERROR_SIGNAR_DOCUMENT);

			// Los ids de los documentos deben existir
			ArrayList<DocsTramitacioRDTO> docsTramitacioRDTOList = new ArrayList<DocsTramitacioRDTO>();
			DocsTramitacioRDTO docsTramitacioRDTO = null;
			for (int i = 0; i < idsDocument.length; i++) {
				docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idsDocument[i]);
				ServeisRestControllerValidationHelper.validateDocumentGenerat(idsDocument[i], docsTramitacioRDTO,
				        Resultat.ERROR_SIGNAR_DOCUMENT);
				docsTramitacioRDTOList.add(docsTramitacioRDTO);
			}

			// Comprobar si la acción es permitida
			// ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			// AccioTramitadorApiParamValue.SIGNAR_DOCUMENT,
			// Resultat.ERROR_SIGNAR_DOCUMENT);

			SignarValidDocument signarValidDocument = new SignarValidDocument();
			signarValidDocument.setValorToken(signaturaValidDocument.getValorToken());
			signarValidDocument.setInformacioToken(signaturaValidDocument.getInformacioToken());
			signarValidDocument.setDocuments(Arrays.asList(idsDocument));
			signarValidDocument.setPoliticaSignatura(signaturaValidDocument.getPoliticaSignatura());
			SignarValidDocumentResponse signarValidDocumentResponse = serveisService.signarValidDocument(signarValidDocument);

			if (signarValidDocumentResponse != null && StringUtils.isNotEmpty(signarValidDocumentResponse.getMissatgeError())) {
				// TODO Lanzar las excepciones de integración en los propios
				// módulos de integración
				StringBuffer stringBufferMessageError = new StringBuffer(Constants.MISSATGE_ERROR_SIGNATURES);
				throw new GPAServeisServiceException(
				        stringBufferMessageError.append(": ").append(signarValidDocumentResponse.getMissatgeError()).toString());
			}

		} catch (GPAApiParamValidationException e) {
			log.error("signarDocumentOnline(BigDecimal[], SignaturaValidDocumentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("signarDocumentOnline(BigDecimal[], SignaturaValidDocumentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_SIGNAR_DOCUMENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/documentacio/" + idsDocument + "/signar/online");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Signar un document en línia");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, signaturaValidDocument, respostaResultatBDTO, ex);
		}

		RespostaSignarDocumentBDTO respostaSignarDocumentBDTO = new RespostaSignarDocumentBDTO(null, respostaResultatBDTO);
		respostaSignarDocumentRDTO = modelMapper.map(respostaSignarDocumentBDTO, RespostaSignarDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("signarDocumentOnline(BigDecimal[], SignaturaValidDocumentRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaSignarDocumentRDTO;
	}

	/**
	 * Preparar signatura document online criptografica.
	 *
	 * @param preparacioSignaturaCriptograficaDocumentMassiu
	 *            the preparacio signatura criptografica document massiu
	 * @return the resposta preparar signatura document RDTO
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/expedients/documentacio/preparar/signatura/online/criptografica")
	@ApiOperation(nickname = "prepararSignaturaDocumentOnlineCriptograficaTramitadors", value = "Preparar la signatura d'un conjunt de documents en línia amb modalitat criptogràfica", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaPrepararSignaturaDocumentRDTO prepararSignaturaDocumentOnlineCriptografica(
	        @ApiParam(value = "Informació addicional per a la preparació de la signatura", required = true) @RequestBody PreparacioSignaturaCriptograficaDocumentMassiuRDTO preparacioSignaturaCriptograficaDocumentMassiu)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("prepararSignaturaDocumentOnlineCriptografica(PreparacioSignaturaCriptograficaDocumentMassiuRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaPrepararSignaturaDocumentRDTO respostaPrepararSignaturaDocumentRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PREPARAR_SIGNATURA_CRIPTOGRAFICA_DOCUMENT);
		PrepararSignaturaCriptograficaDocumentResponse prepararSignaturaCriptograficaDocumentResponse = null;
		try {
			ArrayList<DocsTramitacioRDTO> docsTramitacioRDTOList = new ArrayList<DocsTramitacioRDTO>();
			DocsTramitacioRDTO docsTramitacioRDTO = null;
			ArrayList<PrepararSignaturaCriptograficaDocument> prepararSignaturaCriptograficaDocumentList = new ArrayList<PrepararSignaturaCriptograficaDocument>();
			PrepararSignaturaCriptograficaDocument prepararSignaturaCriptograficaDocument = null;
			for (PreparacioSignaturaCriptograficaDocumentRDTO preparacioSignaturaCriptograficaDocumentRDTO : preparacioSignaturaCriptograficaDocumentMassiu
			        .getDocuments()) {
				// La política de signatura de los documentos debe estar rellena
				ServeisRestControllerValidationHelper.validateDocumentPoliticaSignatura(
				        preparacioSignaturaCriptograficaDocumentRDTO.getPoliticaSignatura(),
				        Resultat.ERROR_PREPARAR_SIGNATURA_CRIPTOGRAFICA_DOCUMENT);

				// Los ids de los documentos deben existir
				docsTramitacioRDTO = serveisService
				        .consultarDadesDocumentGenerat(preparacioSignaturaCriptograficaDocumentRDTO.getIdDocument());
				ServeisRestControllerValidationHelper.validateDocumentGenerat(preparacioSignaturaCriptograficaDocumentRDTO.getIdDocument(),
				        docsTramitacioRDTO, Resultat.ERROR_PREPARAR_SIGNATURA_CRIPTOGRAFICA_DOCUMENT);
				docsTramitacioRDTOList.add(docsTramitacioRDTO);

				prepararSignaturaCriptograficaDocument = new PrepararSignaturaCriptograficaDocument();
				prepararSignaturaCriptograficaDocument.setIdDocument(preparacioSignaturaCriptograficaDocumentRDTO.getIdDocument());
				prepararSignaturaCriptograficaDocument
				        .setPoliticaSignatura(preparacioSignaturaCriptograficaDocumentRDTO.getPoliticaSignatura());
				prepararSignaturaCriptograficaDocumentList.add(prepararSignaturaCriptograficaDocument);
			}

			PrepararSignaturaCriptograficaDocumentMassiu prepararSignaturaCriptograficaDocumentMassiu = new PrepararSignaturaCriptograficaDocumentMassiu();
			prepararSignaturaCriptograficaDocumentMassiu
			        .setPrepararSignaturaCriptograficaDocumentList(prepararSignaturaCriptograficaDocumentList);
			prepararSignaturaCriptograficaDocumentMassiu.setUrlRetorn(preparacioSignaturaCriptograficaDocumentMassiu.getUrlRetorn());

			prepararSignaturaCriptograficaDocumentResponse = serveisService
			        .prepararSignaturaCriptograficaDocument(prepararSignaturaCriptograficaDocumentMassiu);

			if (prepararSignaturaCriptograficaDocumentResponse != null
			        && StringUtils.isNotEmpty(prepararSignaturaCriptograficaDocumentResponse.getDescError())) {
				// TODO Lanzar las excepciones de integración en los propios
				// módulos de integración
				StringBuffer stringBufferMessageError = new StringBuffer(Constants.MISSATGE_ERROR_SIGNATURES);
				throw new GPAServeisServiceException(stringBufferMessageError.append(": ")
				        .append(prepararSignaturaCriptograficaDocumentResponse.getDescError()).toString());
			}

		} catch (GPAApiParamValidationException e) {
			log.error("prepararSignaturaDocumentOnlineCriptografica(PreparacioSignaturaCriptograficaDocumentMassiuRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("prepararSignaturaDocumentOnlineCriptografica(PreparacioSignaturaCriptograficaDocumentMassiuRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler
			        .handleException(Resultat.ERROR_PREPARAR_SIGNATURA_CRIPTOGRAFICA_DOCUMENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/documentacio/preparar/signatura/online/criptografica");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Preparar la signatura d'un conjunt de documents en línia amb modalitat criptogràfica");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, preparacioSignaturaCriptograficaDocumentMassiu,
			        respostaResultatBDTO, ex);
		}

		RespostaSignarDocumentBDTO respostaSignarDocumentBDTO = new RespostaSignarDocumentBDTO(null, respostaResultatBDTO);
		RespostaSignarDocumentRDTO respostaSignarDocumentRDTO = modelMapper.map(respostaSignarDocumentBDTO,
		        RespostaSignarDocumentRDTO.class);

		respostaPrepararSignaturaDocumentRDTO = new RespostaPrepararSignaturaDocumentRDTO();
		respostaPrepararSignaturaDocumentRDTO.setExpedient(respostaSignarDocumentRDTO.getExpedient());
		respostaPrepararSignaturaDocumentRDTO.setResultat(respostaSignarDocumentRDTO.getResultat());
		respostaPrepararSignaturaDocumentRDTO.setIdPeticio(prepararSignaturaCriptograficaDocumentResponse != null
		        ? prepararSignaturaCriptograficaDocumentResponse.getIdPeticio() : null);
		respostaPrepararSignaturaDocumentRDTO.setUrlSignaturaBrowser(prepararSignaturaCriptograficaDocumentResponse != null
		        ? prepararSignaturaCriptograficaDocumentResponse.getUrlSignaturaBrowser() : null);

		if (log.isDebugEnabled()) {
			log.debug("prepararSignaturaDocumentOnlineCriptografica(PreparacioSignaturaCriptograficaDocumentMassiuRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaPrepararSignaturaDocumentRDTO;
	}

	/**
	 * Completar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param file
	 *            the file
	 * @param documentComplecio
	 *            the document complecio
	 * @return the resposta completar document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping(value = "/expedients/{codiExpedient}/documentacio/{idDocument}/completar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(nickname = "completarDocumentExpedientTramitadors", value = "Completar un document", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	@ApiImplicitParams(@ApiImplicitParam(name = "document", value = "Dades del document a completar", dataType = "string", paramType = "form", required = true))
	public RespostaCompletarDocumentRDTO completarDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Fitxer") @RequestParam(value = "file", required = false) MultipartFile file,
	        @RequestParam("document") DocumentComplecioRDTO documentComplecio) throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("completarDocumentExpedient(String, BigDecimal, DocumentComplecioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaCompletarDocumentRDTO respostaCompletarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RegistreAssentamentRDTO registreAssentamentRDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		DocsTramitacioRDTO docsTramitacioRDTOResult = null;
		Boolean esAportada = null;
		BigDecimal documentacioId = null;
		Integer declaracioResponsable = null;
		BigDecimal docsFisicsIdAnterior = null;
		Integer docsFisicsPlantillaAnterior = null;
		ArrayList<BigDecimal> idDadesOperacionsList = null;
		ArrayList<BigDecimal> idConfiguracioDocsEntradaList = null;
		Requeriments requeriments = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_COMPLETAR_DOCUMENT_EXPEDIENT);
		GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO = null;
		GuardarDocumentTramitacioFitxerBDTO guardarDocumentTramitacioFitxerBDTO = null;
		try {
			ConfiguracioApiParamValueTranslator configuracioApiParamValueTranslator = new ConfiguracioApiParamValueTranslator();
			ConfiguracioApiParamValue configuracioApiParamValue = configuracioApiParamValueTranslator
			        .getEnumByApiParamValue(documentComplecio.getDocument().getConfiguracio());
			switch (configuracioApiParamValue) {
			case APORTADA:
				esAportada = Boolean.TRUE;

				break;
			case GENERADA:
				esAportada = Boolean.FALSE;

				break;
			default:
				break;
			}

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			if (BooleanUtils.isTrue(esAportada)) {
				docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
				documentacioId = docsEntradaRDTO.getDocumentacio();
				declaracioResponsable = docsEntradaRDTO.getDeclaracioResponsable();
				ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO.getExpedientsRDTO(),
				        Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);
			} else {
				DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocument);
				documentacioId = docsTramitacioRDTO.getDocumentacio();
				docsFisicsIdAnterior = docsTramitacioRDTO.getDocsFisics().getId();
				docsFisicsPlantillaAnterior = docsTramitacioRDTO.getDocsFisics().getPlantilla();
				if (documentComplecio.getDocument().getRequeriment()) {
					requeriments = docsTramitacioRDTO.getRequeriments();
				}

				ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
				        Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);
			}

			if (esAportada) {
				// El número de registro indicado debe existir
				registreAssentamentRDTO = serveisService
				        .consultarDadesRegistreAssentament(documentComplecio.getDocument().getNumeroRegistre());
				ServeisRestControllerValidationHelper.validateRegistreAssentament(registreAssentamentRDTO,
				        Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);
			}

			// Completar documento si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.COMPLETAR_DOCUMENT, Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

			if (documentComplecio.getDocument().getRequeriment())
				// Los Datos de Operación deben existir, estar asociados al
				// procedimiento y tener asociado el trámite OVT de Esmena. Se
				// aprovecha para recuperar los identificadores de los campos

				if (CollectionUtils.isNotEmpty(documentComplecio.getDadesOperacioRequerits())) {
					DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
					        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
					RespostaDadesOperacioRequeritsCercaBDTO respostaDadesOperacioRequeritsCercaBDTO = serveisService
					        .cercaDadesOperacioRequerits(dadesOperacioCercaBDTO);
					idDadesOperacionsList = ServeisRestControllerValidationHelper.validateDadesOperacioPrepararRequerimentExpedient(
					        documentComplecio.getDadesOperacioRequerits(),
					        respostaDadesOperacioRequeritsCercaBDTO.getDadesOperacionsRDTOList());
				}

			// Las Configuraciones de Documentación deben existir, estar
			// asociados al procedimiento y tener asociado el trámite OVT de
			// Esmena
			if (CollectionUtils.isNotEmpty(documentComplecio.getDocumentacioRequerida())) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(),
				        TramitOvtApiParamValue.REQ.getInternalValue());
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsEntradaCercaBDTO);
				idConfiguracioDocsEntradaList = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioPrepararRequerimentExpedient(documentComplecio.getDocumentacioRequerida(),
				                respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList());
			}

			// Completar documento, pudiéndose tratar de entrada o tramitación
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			if (BooleanUtils.isTrue(esAportada)) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
				HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioEntradaCompletat(
				                respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(), documentComplecio.getDocument(),
				                Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

				docsEntradaRDTO = modelMapper.map(documentComplecio.getDocument(), DocsEntradaRDTO.class);
				docsEntradaRDTO
				        .setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
				docsEntradaRDTO.setId(idDocument);
				docsEntradaRDTO.setDocumentacio(documentacioId);
				docsEntradaRDTO.setDeclaracioResponsable(declaracioResponsable);

				if (registreAssentamentRDTO != null) {
					RegistreAssentament registreAssentament = new RegistreAssentament();
					registreAssentament.setId(registreAssentamentRDTO.getId());
					docsEntradaRDTO.setRegistreAssentament(registreAssentament);
				}

				if ((new Integer(1)).equals(docsEntradaRDTO.getDeclaracioResponsable())) {
					ActualitzarDeclaracioResponsableBDTO actualitzarDeclaracioResponsableBDTO = new ActualitzarDeclaracioResponsableBDTO(
					        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
					docsEntradaRDTOResult = serveisService.actualitzarDeclaracioResponsable(actualitzarDeclaracioResponsableBDTO);
				} else {
					if (file != null) {
						guardarDocumentEntradaFitxerBDTO = new GuardarDocumentEntradaFitxerBDTO(
						        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO, file, null);
						docsEntradaRDTOResult = serveisService.guardarDocumentEntradaFitxer(guardarDocumentEntradaFitxerBDTO);
					} else {
						ActualitzarDocumentEntradaBDTO actualitzarDocumentEntradaBDTO = new ActualitzarDocumentEntradaBDTO(
						        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
						docsEntradaRDTOResult = serveisService.actualitzarDocumentEntrada(actualitzarDocumentEntradaBDTO);
					}
				}
			} else {
				DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
				RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
				HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioTramitacioCompletat(
				                respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
				                documentComplecio.getDocument(), Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

				DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(documentComplecio.getDocument(), DocsTramitacioRDTO.class);
				docsTramitacioRDTO.setConfigDocTramitacio(
				        configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());
				docsTramitacioRDTO.setId(idDocument);
				docsTramitacioRDTO.setDocumentacio(documentacioId);

				if (file != null) {
					if (documentComplecio.getDocument().getRequeriment()) {
						docsTramitacioRDTO.setRequeriments(requeriments);

						GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
						guardarRequerimentExpedient.setDocsTramitacio(docsTramitacioRDTO);
						guardarRequerimentExpedient.setIdsDadesOperList(idDadesOperacionsList);
						guardarRequerimentExpedient.setIdsConfDocEntradaList(idConfiguracioDocsEntradaList);

						GuardarRequerimentFitxerBDTO guardarRequerimentFitxerBDTO = new GuardarRequerimentFitxerBDTO(
						        dadesExpedientBDTO.getExpedientsRDTO().getId(), guardarRequerimentExpedient, file);
						docsTramitacioRDTOResult = serveisService.guardarRequerimentFitxer(guardarRequerimentFitxerBDTO);
					} else {
						guardarDocumentTramitacioFitxerBDTO = new GuardarDocumentTramitacioFitxerBDTO(
						        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsTramitacioRDTO, file);
						docsTramitacioRDTOResult = serveisService.guardarDocumentTramitacioFitxer(guardarDocumentTramitacioFitxerBDTO);
					}

				} else {
					if (documentComplecio.getDocument().getPlantillaPdf() && (new Integer(0)).equals(docsFisicsPlantillaAnterior)) {
						DocsFisics docsFisics = new DocsFisics();
						docsFisics.setId(docsFisicsIdAnterior);
						docsFisics.setPlantilla(docsFisicsPlantillaAnterior);
						docsTramitacioRDTO.setDocsFisics(docsFisics);

						ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
						configuracioDocsTramitacio.setSuportEnllac(configuracioDocsTramitacioMap
						        .get(documentComplecio.getDocument().getConfiguracioDocumentacio()).getSuportEnllac());
						docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
					}

					if (documentComplecio.getDocument().getRequeriment()) {
						docsTramitacioRDTO.setRequeriments(requeriments);

						GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
						guardarRequerimentExpedient.setDocsTramitacio(docsTramitacioRDTO);
						guardarRequerimentExpedient.setIdsDadesOperList(idDadesOperacionsList);
						guardarRequerimentExpedient.setIdsConfDocEntradaList(idConfiguracioDocsEntradaList);

						CrearRequerimentBDTO crearRequerimentBDTO = new CrearRequerimentBDTO(dadesExpedientBDTO.getExpedientsRDTO().getId(),
						        guardarRequerimentExpedient);
						docsTramitacioRDTOResult = serveisService.actualitzarRequeriment(crearRequerimentBDTO);

					} else {
						ActualitzarDocumentTramitacioBDTO actualitzarDocumentTramitacioBDTO = new ActualitzarDocumentTramitacioBDTO(
						        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsTramitacioRDTO);
						docsTramitacioRDTOResult = serveisService.actualitzarDocumentTramitacio(actualitzarDocumentTramitacioBDTO);
					}

				}
			}

		} catch (GPAApiParamValidationException e) {
			log.error("completarDocumentExpedient(String, BigDecimal, DocumentComplecioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("completarDocumentExpedient(String, BigDecimal, DocumentComplecioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/" + idDocument + "/completar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Validar un document");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, documentComplecio, respostaResultatBDTO, ex);

		}

		if (BooleanUtils.isTrue(esAportada)) {
			RespostaCompletarDocumentEntradaExpedientBDTO respostaCompletarDocumentEntradaExpedientBDTO = new RespostaCompletarDocumentEntradaExpedientBDTO(
			        docsEntradaRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
			        respostaResultatBDTO);
			respostaCompletarDocumentRDTO = modelMapper.map(respostaCompletarDocumentEntradaExpedientBDTO,
			        RespostaCompletarDocumentRDTO.class);
		} else {
			RespostaCompletarDocumentTramitacioExpedientBDTO respostaCompletarDocumentTramitacioExpedientBDTO = new RespostaCompletarDocumentTramitacioExpedientBDTO(
			        docsTramitacioRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
			        respostaResultatBDTO);
			respostaCompletarDocumentRDTO = modelMapper.map(respostaCompletarDocumentTramitacioExpedientBDTO,
			        RespostaCompletarDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("completarDocumentExpedient(String, BigDecimal, DocumentComplecioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaCompletarDocumentRDTO;
	}

	/**
	 * Presentar declaracio responsable expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param declaracioResponsablePresentacio
	 *            the declaracio responsable presentacio
	 * @return the resposta presentar declaracio responsable RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/declaracio/responsable")
	@ApiOperation(nickname = "presentarDeclaracioResponsableExpedientTramitadors", value = "Presentar declaració responsable", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaPresentarDeclaracioResponsableRDTO presentarDeclaracioResponsableExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades del document a incorporar") @RequestBody DeclaracioResponsablePresentacioRDTO declaracioResponsablePresentacio)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("presentarDeclaracioResponsableExpedient(String, DeclaracioResponsablePresentacioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaPresentarDeclaracioResponsableRDTO respostaPresentarDeclaracioResponsableRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RegistreAssentamentRDTO registreAssentamentRDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO,
			        Resultat.ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT);

			// El número de registro indicado debe existir
			registreAssentamentRDTO = serveisService
			        .consultarDadesRegistreAssentament(declaracioResponsablePresentacio.getDocument().getNumeroRegistre());
			ServeisRestControllerValidationHelper.validateRegistreAssentament(registreAssentamentRDTO,
			        Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

			// Incorporar un nuevo documento electrónico al expediente si la
			// acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.PRESENTAR_DECLARACIO_RESPONSABLE,
			        Resultat.ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT);

			// Presentar Declaración Responsable
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
			        .validateConfiguracioDocumentacioEntradaDeclaracioResponsablePresentada(
			                respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
			                declaracioResponsablePresentacio.getDocument(), Resultat.ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT);

			DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(declaracioResponsablePresentacio.getDocument(), DocsEntradaRDTO.class);
			docsEntradaRDTO
			        .setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
			docsEntradaRDTO.setDeclaracioResponsable(BooleanApiParamValue.TRUE.getInternalValue());

			RegistreAssentament registreAssentament = new RegistreAssentament();
			registreAssentament.setId(registreAssentamentRDTO.getId());
			docsEntradaRDTO.setRegistreAssentament(registreAssentament);

			CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO = new CrearDeclaracioResponsableBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
			docsEntradaRDTOResult = serveisService.crearDeclaracioResponsable(crearDeclaracioResponsableBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("presentarDeclaracioResponsableExpedient(String, DeclaracioResponsablePresentacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("presentarDeclaracioResponsableExpedient(String, DeclaracioResponsablePresentacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler
			        .handleException(Resultat.ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/declaracio/responsable");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Presentar declaració responsable");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, declaracioResponsablePresentacio, respostaResultatBDTO,
			        ex);
		}

		RespostaPresentarDeclaracioResponsableExpedientBDTO respostaPresentarDeclaracioResponsableExpedientBDTO = new RespostaPresentarDeclaracioResponsableExpedientBDTO(
		        docsEntradaRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaPresentarDeclaracioResponsableRDTO = modelMapper.map(respostaPresentarDeclaracioResponsableExpedientBDTO,
		        RespostaPresentarDeclaracioResponsableRDTO.class);
		if (log.isDebugEnabled()) {
			log.debug("presentarDeclaracioResponsableExpedient(String, DeclaracioResponsablePresentacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaPresentarDeclaracioResponsableRDTO;
	}

	/**
	 * Preparar requeriment expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param file
	 *            the file
	 * @param requerimentPreparacio
	 *            the requeriment preparacio
	 * @return the resposta preparar requeriment RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping(value = "/expedients/{codiExpedient}/documentacio/requeriment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(nickname = "prepararRequerimentExpedientTramitadors", value = "Preparar un requeriment a l’interessat", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	@ApiImplicitParams(@ApiImplicitParam(name = "requeriment", value = "Dades del requeriment a preparar", dataType = "string", paramType = "form", required = true))
	public RespostaPrepararRequerimentRDTO prepararRequerimentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Fitxer") @RequestParam(value = "file", required = false) MultipartFile file,
	        @RequestParam("requeriment") RequerimentPreparacioRDTO requerimentPreparacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("prepararRequerimentExpedient(String, RequerimentPreparacioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaPrepararRequerimentRDTO respostaPrepararRequerimentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsTramitacioRDTO docsTramitacioRDTOResult = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PREPARAR_REQUERIMENT_EXPEDIENT);
		CrearRequerimentBDTO crearRequerimentBDTO = null;
		GuardarRequerimentFitxerBDTO guardarRequerimentFitxerBDTO = null;
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT);

			// Preparar un requerimiento para el expediente si la acción es
			// permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.PREPARAR_REQUERIMENT_INTERESSAT, Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT);

			// Los Datos de Operación deben existir, estar asociados al
			// procedimiento y tener asociado el trámite OVT de Esmena. Se
			// aprovecha para recuperar los identificadores de los campos
			ArrayList<BigDecimal> idDadesOperacionsList = null;
			if (CollectionUtils.isNotEmpty(requerimentPreparacio.getDadesOperacioRequerits())) {
				DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
				RespostaDadesOperacioRequeritsCercaBDTO respostaDadesOperacioRequeritsCercaBDTO = serveisService
				        .cercaDadesOperacioRequerits(dadesOperacioCercaBDTO);
				idDadesOperacionsList = ServeisRestControllerValidationHelper.validateDadesOperacioPrepararRequerimentExpedient(
				        requerimentPreparacio.getDadesOperacioRequerits(),
				        respostaDadesOperacioRequeritsCercaBDTO.getDadesOperacionsRDTOList());
			}

			// Las Configuraciones de Documentación deben existir, estar
			// asociados al procedimiento y tener asociado el trámite OVT de
			// Esmena
			ArrayList<BigDecimal> idConfiguracioDocsEntradaList = null;
			if (CollectionUtils.isNotEmpty(requerimentPreparacio.getDocumentacioRequerida())) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(),
				        TramitOvtApiParamValue.REQ.getInternalValue());
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsEntradaCercaBDTO);
				idConfiguracioDocsEntradaList = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioPrepararRequerimentExpedient(requerimentPreparacio.getDocumentacioRequerida(),
				                respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList());
			}

			// Preparar el requerimiento
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
			RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
			HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
			        .validateConfiguracioDocumentacioTramitacioRequerimentPreparat(
			                respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
			                requerimentPreparacio.getDocument(), Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT);

			DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(requerimentPreparacio.getDocument(), DocsTramitacioRDTO.class);
			docsTramitacioRDTO.setConfigDocTramitacio(
			        configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());

			GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
			guardarRequerimentExpedient.setDocsTramitacio(docsTramitacioRDTO);
			guardarRequerimentExpedient.setIdsDadesOperList(idDadesOperacionsList);
			guardarRequerimentExpedient.setIdsConfDocEntradaList(idConfiguracioDocsEntradaList);

			if (requerimentPreparacio.getDocument().getPlantillaPdf()) {
				ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
				configuracioDocsTramitacio.setSuportEnllac(configuracioDocsTramitacioMap
				        .get(requerimentPreparacio.getDocument().getConfiguracioDocumentacio()).getSuportEnllac());
				docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);

				crearRequerimentBDTO = new CrearRequerimentBDTO(dadesExpedientBDTO.getExpedientsRDTO().getId(),
				        guardarRequerimentExpedient);
				docsTramitacioRDTOResult = serveisService.guardarRequerimentPlantilla(crearRequerimentBDTO);
			} else {
				guardarRequerimentFitxerBDTO = new GuardarRequerimentFitxerBDTO(dadesExpedientBDTO.getExpedientsRDTO().getId(),
				        guardarRequerimentExpedient, file);
				docsTramitacioRDTOResult = serveisService.guardarRequerimentFitxer(guardarRequerimentFitxerBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("prepararRequerimentExpedient(String, RequerimentPreparacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("prepararRequerimentExpedient(String, RequerimentPreparacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/requeriment");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Preparar un requeriment a l’interessat");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, crearRequerimentBDTO, respostaResultatBDTO, ex);
		}

		RespostaPrepararRequerimentExpedientBDTO respostaPrepararRequerimentExpedientBDTO = new RespostaPrepararRequerimentExpedientBDTO(
		        docsTramitacioRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaPrepararRequerimentRDTO = modelMapper.map(respostaPrepararRequerimentExpedientBDTO, RespostaPrepararRequerimentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("prepararRequerimentExpedient(String, RequerimentPreparacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaPrepararRequerimentRDTO;
	}

	/**
	 * Acumular expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientAcumulacio
	 *            the expedient acumulacio
	 * @return the resposta acumular expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/acumular")
	@ApiOperation(nickname = "acumularExpedientTramitadors", value = "Acumular expedients", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAcumularExpedientRDTO acumularExpedient(
	        @ApiParam(value = "Codi de l'expedient acumulador", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de l'acumulació d'expedient") @RequestBody ExpedientAcumulacioRDTO expedientAcumulacio)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("acumularExpedient(String, ExpedientAcumulacioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaAcumularExpedientRDTO respostaAcumularExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientAcumulador = null;
		DadesExpedientBDTO dadesExpedientAcumular = null;
		List<ExpedientsRDTO> expedientsAcumulatsRDTOList = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACUMULAR_EXPEDIENT);
		try {
			// El codi del expediente acumulador debe existir y no debe estar ya
			// acumulado
			dadesExpedientAcumulador = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			PageDataOfExpedientsRDTO pageDataOfExpedientsAcumuladorRDTO = null;
			List<ExpedientsRDTO> expedientsRelacionatsAcumuladorRDTOList = null;
			if (dadesExpedientAcumulador.getExpedientsRDTO() == null) {
				pageDataOfExpedientsAcumuladorRDTO = serveisService
				        .obtenirExpedientsRelacionats(dadesExpedientAcumulador.getExpedientsRDTO().getId());
				expedientsRelacionatsAcumuladorRDTOList = pageDataOfExpedientsAcumuladorRDTO.getData();
			}
			ServeisRestControllerValidationHelper.validateExpedientAcumulador(dadesExpedientAcumulador,
			        expedientsRelacionatsAcumuladorRDTOList, Resultat.ERROR_ACUMULAR_EXPEDIENT);

			// El codi del expediente a acumular debe existir, ser diferente al
			// acumulador indicado, pertenecer al mismo procedimiento y no estar
			// ya acumulado a otro expediente
			dadesExpedientAcumular = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(expedientAcumulacio.getCodiExpedient(), expedientsIdOrgan));
			PageDataOfExpedientsRDTO pageDataOfExpedientsAcumularRDTO = null;
			List<ExpedientsRDTO> expedientsRelacionatsAcumularRDTOList = null;
			if (dadesExpedientAcumular.getExpedientsRDTO() == null) {
				pageDataOfExpedientsAcumularRDTO = serveisService
				        .obtenirExpedientsRelacionats(dadesExpedientAcumular.getExpedientsRDTO().getId());
				expedientsRelacionatsAcumularRDTOList = pageDataOfExpedientsAcumularRDTO.getData();
			}
			ServeisRestControllerValidationHelper.validateExpedientAcumular(dadesExpedientAcumulador, dadesExpedientAcumular,
			        expedientsRelacionatsAcumularRDTOList, Resultat.ERROR_ACUMULAR_EXPEDIENT);

			// Acumular expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientAcumulador,
			        AccioTramitadorApiParamValue.ACUMULAR_EXPEDIENTS, Resultat.ERROR_ACUMULAR_EXPEDIENT);

			// Acumular expediente
			AcumularExpedientRDTO acumularExpedientRDTO = new AcumularExpedientRDTO();
			acumularExpedientRDTO.setIdExpedientAcumulador(dadesExpedientAcumulador.getExpedientsRDTO().getId());
			acumularExpedientRDTO.setCodiExpedientAcumulador(dadesExpedientAcumulador.getExpedientsRDTO().getCodi());
			HashMap<String, String> expedientsAcumulatsMap = new HashMap<String, String>();
			expedientsAcumulatsMap.put(dadesExpedientAcumular.getExpedientsRDTO().getId().toString(),
			        dadesExpedientAcumular.getExpedientsRDTO().getCodi());
			acumularExpedientRDTO.setExpedientsAcumulats(expedientsAcumulatsMap);
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(expedientAcumulacio.getComentari());
			acumularExpedientRDTO.setComentari(comentaris);
			ExpedientsAcumularBDTO expedientsAcumularBDTO = new ExpedientsAcumularBDTO(acumularExpedientRDTO);
			serveisService.acumularExpedient(expedientsAcumularBDTO);

			// Se obtiene la lista actualizada de expedientes acumulados
			expedientsAcumulatsRDTOList = serveisService.cercaExpedientsAcumulats(dadesExpedientAcumulador.getExpedientsRDTO().getId());

		} catch (GPAApiParamValidationException e) {
			log.error("acumularExpedient(String, ExpedientAcumulacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("acumularExpedient(String, ExpedientAcumulacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ACUMULAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/acumular");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Presentar declaració responsable");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientAcumulacio, respostaResultatBDTO, ex);
		}

		RespostaExpedientsAcumularBDTO respostaExpedientsAcumularBDTO = new RespostaExpedientsAcumularBDTO(
		        dadesExpedientAcumulador != null ? dadesExpedientAcumulador.getExpedientsRDTO() : null, expedientsAcumulatsRDTOList,
		        respostaResultatBDTO);

		respostaAcumularExpedientRDTO = modelMapper.map(respostaExpedientsAcumularBDTO, RespostaAcumularExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("acumularExpedient(String, ExpedientAcumulacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaAcumularExpedientRDTO;
	}

	/**
	 * Acces expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientAcces
	 *            the expedient acces
	 * @return the resposta acces expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/acces")
	@ApiOperation(nickname = "accesExpedientTramitadors", value = "Accés a l'expedient (funcionari dona accés)", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAccesExpedientRDTO accesExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de l'accés a l'expedient", required = false) @RequestBody ExpedientAccesRDTO expedientAcces)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("accesExpedient(String, ExpedientAccesRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaAccesExpedientRDTO respostaAccesExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		PersonesSollicitudRDTO personesSollicitudRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACCES_EXPEDIENT);
		try {

			// desde tramitadors no se controla la visibilidad, solo afecta a
			// portal
			BigDecimal visibilitat = BigDecimal.ONE;

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan), visibilitat);
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ACCES_EXPEDIENT);

			// El documento de identidad debe corresponderse con el de una
			// persona implicada en el expediente
			personesSollicitudRDTO = ServeisRestControllerValidationHelper.validatePersonaImplicadaExpedient(dadesExpedientBDTO,
			        expedientAcces.getDocumentsIdentitatRDTO().getNumeroDocument(), Resultat.ERROR_ACCES_EXPEDIENT);

			// Dar acceso al expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.ACCES_EXPEDIENT, Resultat.ERROR_ACCES_EXPEDIENT);

			// Se actualiza la persona indicada estableciendo el flag
			// VISIBILITAT_OVT a true
			personesSollicitudRDTO.setVisibilitatOvt(BooleanApiParamValue.TRUE.getInternalValue());
			serveisService.actualitzarDadesAltraPersonaImplicada(personesSollicitudRDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("accesExpedient(String, ExpedientAccesRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("accesExpedient(String, ExpedientAccesRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ACCES_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/acces");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Accés a l'expedient (funcionari dona accés)");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientAcces, respostaResultatBDTO, ex);
		}

		RespostaExpedientsAccesBDTO respostaExpedientsAccesBDTO = new RespostaExpedientsAccesBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaAccesExpedientRDTO = modelMapper.map(respostaExpedientsAccesBDTO, RespostaAccesExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("accesExpedient(String, ExpedientAccesRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaAccesExpedientRDTO;
	}

	/**
	 * Registrar comunicacio expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param expedientComunicat
	 *            the expedient comunicat
	 * @return the resposta registrar comunicacio expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/comunicat")
	@ApiOperation(nickname = "registrarComunicacioExpedientTramitadors", value = "Registrar comunicació de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRegistrarComunicacioExpedientRDTO registrarComunicacioExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Dades de la comunicació de l'expedient") @RequestBody ExpedientComunicatRDTO expedientComunicat)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("registrarComunicacioExpedient(String, ExpedientComunicatRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaRegistrarComunicacioExpedientRDTO respostaRegistrarComunicacioExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REGISTRAR_COMUNICACIO_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_REGISTRAR_COMUNICACIO_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
			        Resultat.ERROR_REGISTRAR_COMUNICACIO_EXPEDIENT);

			// Registrar comunicación del expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.REGISTRAR_COMUNICACIO, Resultat.ERROR_REGISTRAR_COMUNICACIO_EXPEDIENT);

			// Registrar comunicación
			DocumentRegistrarComunicat documentRegistrarComunicat = new DocumentRegistrarComunicat();
			documentRegistrarComunicat.setDocsTramitacioId(idDocument);
			documentRegistrarComunicat.setDataComunicat(DateTime.now());
			TipusCanalComunicacioApiParamValueTranslator tipusCanalComunicacioApiParamValueTranslator = new TipusCanalComunicacioApiParamValueTranslator();
			TipusCanalComunicacioApiParamValue tipusCanalComunicacioApiParamValue = tipusCanalComunicacioApiParamValueTranslator
			        .getEnumByApiParamValue(expedientComunicat.getCanal().toUpperCase());
			documentRegistrarComunicat.setCanalComunicat(tipusCanalComunicacioApiParamValue.getInternalValue());
			documentRegistrarComunicat.setMissatgeComunicat(expedientComunicat.getComentari());
			DocumentGeneratRegistrarComunicatBDTO documentGeneratRegistrarComunicatBDTO = new DocumentGeneratRegistrarComunicatBDTO(
			        documentRegistrarComunicat);
			serveisService.registrarComunicatDocumentTramitacio(documentGeneratRegistrarComunicatBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientComunicat.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.REGISTRAR_COMUNICACIO.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("registrarComunicacioExpedient(String, ExpedientComunicatRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("registrarComunicacioExpedient(String, ExpedientComunicatRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_REGISTRAR_COMUNICACIO_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/" + idDocument + "/comunicat");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Registrar comunicació de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientComunicat, respostaResultatBDTO, ex);
		}

		RespostaExpedientsRegistrarComunicacioBDTO respostaExpedientsRegistrarComunicacioBDTO = new RespostaExpedientsRegistrarComunicacioBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaRegistrarComunicacioExpedientRDTO = modelMapper.map(respostaExpedientsRegistrarComunicacioBDTO,
		        RespostaRegistrarComunicacioExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("registrarComunicacioExpedient(String, ExpedientComunicatRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaRegistrarComunicacioExpedientRDTO;
	}

	/**
	 * Notificar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocumentPrincipal
	 *            the id document principal
	 * @param expedientNotificacio
	 *            the expedient notificacio
	 * @return the resposta notificar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocumentPrincipal}/notificar")
	@ApiOperation(nickname = "notificarExpedientTramitadors", value = "Enviar notificació de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaNotificarExpedientRDTO notificarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document principal", required = true) @PathVariable BigDecimal idDocumentPrincipal,
	        @ApiParam(value = "Dades de la notificació de l'expedient") @RequestBody ExpedientNotificacioRDTO expedientNotificacio)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("notificarExpedient(String, ExpedientNotificacioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaNotificarExpedientRDTO respostaNotificarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		BigDecimal idNotificacio = null;
		NotificacionsRDTO notificacionsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_NOTIFICAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_NOTIFICAR_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocumentPrincipal);
			ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
			        Resultat.ERROR_NOTIFICAR_EXPEDIENT);

			if (CollectionUtils.isNotEmpty(expedientNotificacio.getIdsAnnexosList())) {
				for (BigDecimal idAnnexe : expedientNotificacio.getIdsAnnexosList()) {
					docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idAnnexe);
					ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
					        Resultat.ERROR_NOTIFICAR_EXPEDIENT);
				}
			}

			// Notificar si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.NOTIFICAR, Resultat.ERROR_NOTIFICAR_EXPEDIENT);

			// Crear Notificación
			CrearNotificacio crearNotificacio = modelMapper.map(expedientNotificacio, CrearNotificacio.class);
			crearNotificacio.setCodiExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			crearNotificacio.setIdDocumentPrincipal(idDocumentPrincipal);
			crearNotificacio.setIdsAnnexosList(expedientNotificacio.getIdsAnnexosList());
			crearNotificacio.setIdExpedient(dadesExpedientBDTO.getExpedientsRDTO().getId());
			crearNotificacio.setIdProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());
			crearNotificacio.setCodiProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentCodi());
			crearNotificacio.setComunicar(expedientNotificacio.getComunicar());
			DocumentCrearNotificacioBDTO documentCrearNotificacioBDTO = new DocumentCrearNotificacioBDTO(crearNotificacio);
			notificacionsRDTO = serveisService.crearNotificacio(documentCrearNotificacioBDTO);
			idNotificacio = notificacionsRDTO.getNotificacioId();

		} catch (GPAApiParamValidationException e) {
			log.error("notificarExpedient(String, ExpedientNotificacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("notificarExpedient(String, ExpedientNotificacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_NOTIFICAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/" + idDocumentPrincipal + "/notificar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Enviar notificació de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientNotificacio, respostaResultatBDTO, ex);
		}

		if (notificacionsRDTO != null && StringUtils.isNotEmpty(notificacionsRDTO.getCodiError())) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setCodi(notificacionsRDTO.getCodiError());
			errorDTO.setDescripcio(notificacionsRDTO.getMissatgeError());

			ResultatRespostaDTO resultatRespostaDTO = new ResultatRespostaDTO();
			resultatRespostaDTO.setCodi(notificacionsRDTO.getCodiError());
			resultatRespostaDTO.setDetallError(errorDTO);

			respostaNotificarExpedientRDTO = new RespostaNotificarExpedientRDTO();
			respostaNotificarExpedientRDTO.setResultat(resultatRespostaDTO);
		} else {
			RespostaExpedientsNotificarBDTO respostaExpedientsNotificarBDTO = new RespostaExpedientsNotificarBDTO(
			        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO, idNotificacio);
			respostaNotificarExpedientRDTO = modelMapper.map(respostaExpedientsNotificarBDTO, RespostaNotificarExpedientRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("notificarExpedient(String, ExpedientNotificacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaNotificarExpedientRDTO;
	}

	@PostMapping("/expedients/{codiExpedient}/documentacio/signat")
	@ApiOperation(nickname = "documentSignatExpedientTramitadors", value = "Força el canvi d'estat de l'expedient a Finzalizado i Comunicat després de la signatura dels documents", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaDocumentSignatExpedientRDTO documentSignatExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de l'expedient amb document signat") @RequestBody ExpedientDocumentSignatRDTO expedientDocumentSignatRDTO)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("documentSignatExpedient(String, ExpedientDocumentSignatRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaDocumentSignatExpedientRDTO respostaDocumentSignatExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_DOCUMENT_SIGNAT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_DOCUMENT_SIGNAT_EXPEDIENT);

			// Documento firmado si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.DOCUMENT_SIGNAT, Resultat.ERROR_DOCUMENT_SIGNAT_EXPEDIENT);

			// Validar que todos los documentos del expediente estén firmados
			Boolean documentsSignats = serveisService
			        .comprovarDocumentsSignatsExpedient(dadesExpedientBDTO.getExpedientsRDTO().getDocumentacioIdext());
			ServeisRestControllerValidationHelper.validateDocumentsSignatsExpedient(documentsSignats);

			// Cambio de estado del expediente
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientDocumentSignatRDTO.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.DOCUMENT_SIGNAT.getInternalValue(), dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			// debe existir una transicion posible para el estado actual
			ServeisRestControllerValidationHelper.validateTransicioAccioDisponibleExpedient(accionsEstatsRDTOList,
			        AccioTramitadorApiParamValue.DOCUMENT_SIGNAT, Resultat.ERROR_DOCUMENT_SIGNAT_EXPEDIENT);

			expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());
			expedientCanviEstat.setDiesTerminiAllegacio(null);
			expedientCanviEstat.setDiesTerminiRequeriment(null);

			ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());
			serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("documentSignatExpedient(String, ExpedientDocumentSignatRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("documentSignatExpedient(String, ExpedientDocumentSignatRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_DOCUMENT_SIGNAT_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/signat");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio(
			        "Força el canvi d'estat de l'expedient a Finzalizado i Comunicat després de la signatura dels documents");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientDocumentSignatRDTO, respostaResultatBDTO, ex);
		}

		RespostaExpedientsDocumentSignatBDTO respostaExpedientsDocumentSignatBDTO = new RespostaExpedientsDocumentSignatBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaDocumentSignatExpedientRDTO = modelMapper.map(respostaExpedientsDocumentSignatBDTO,
		        RespostaDocumentSignatExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("documentSignatExpedient(String, ExpedientDocumentSignatRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaDocumentSignatExpedientRDTO;
	}

	/**
	 * Obtenir document intraoperabilitat.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param documentIntraoperabilitatRDTO
	 *            the document intraoperabilitat RDTO
	 * @return the resposta incorporar nou document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping(value = "/expedients/{codiExpedient}/documentacio/{idDocument}/intraoperabilitat")
	@ApiOperation(nickname = "obtenirDocumentIntraoperabilitatTramitadors", value = "Obtenir un document per intraoperabilitat", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaObtenirDocumentIntraoperabilitatRDTO obtenirDocumentIntraoperabilitat(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Dades del document de l'expedient") @RequestBody DocumentIntraoperabilitatRDTO documentIntraoperabilitatRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obtenirDocumentIntraoperabilitat(String, String, DocumentIntraoperabilitatRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaObtenirDocumentIntraoperabilitatRDTO respostaObtenirDocumentIntraoperabilitatRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTODestino = null;
		DadesExpedientBDTO dadesExpedientBDTOOrigen = null;
		RegistreAssentamentRDTO registreAssentamentRDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		DocsEntradaRDTO consultarDadesDocumentAportat = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_OBTENIR_DOCUMENT_INTRAOPERABILITAT);
		try {
			// El codi del expediente destino debe existir
			dadesExpedientBDTODestino = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTODestino,
			        Resultat.ERROR_OBTENIR_DOCUMENT_INTRAOPERABILITAT);

			// El número de registro indicado debe existir
			registreAssentamentRDTO = serveisService.consultarDadesRegistreAssentament(documentIntraoperabilitatRDTO.getNumeroRegistre());
			ServeisRestControllerValidationHelper.validateRegistreAssentament(registreAssentamentRDTO,
			        Resultat.ERROR_OBTENIR_DOCUMENT_INTRAOPERABILITAT);

			// Obtener datos del expediente origen del documento
			consultarDadesDocumentAportat = serveisService.consultarDadesDocumentAportat(idDocument);
			dadesExpedientBDTOOrigen = serveisService
			        .consultarDadesBasiquesExpedientByIdDocumentacio(consultarDadesDocumentAportat.getDocumentacio());
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTOOrigen,
			        Resultat.ERROR_OBTENIR_DOCUMENT_INTRAOPERABILITAT);

			// Obtener un documento por intraoperabilitat si la acción es
			// permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTODestino,
			        AccioTramitadorApiParamValue.OBTENIR_DOCUMENT_INTRAOPERABILITAT, Resultat.ERROR_OBTENIR_DOCUMENT_INTRAOPERABILITAT);

			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
			        dadesExpedientBDTODestino.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
			        .validateConfiguracioDocumentacioEntradaIntraoperabilitat(
			                respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(), documentIntraoperabilitatRDTO,
			                Resultat.ERROR_OBTENIR_DOCUMENT_INTRAOPERABILITAT);

			DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentIntraoperabilitatRDTO, DocsEntradaRDTO.class);
			docsEntradaRDTO
			        .setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
			docsEntradaRDTO.setRegistreIdext(registreAssentamentRDTO.getId());

			DocsAssociatsIntra docsAssociatsIntra = new DocsAssociatsIntra();
			docsAssociatsIntra.setDocsEntrada(docsEntradaRDTO);
			docsAssociatsIntra.setIdDocumentOriginal(idDocument);
			docsAssociatsIntra.setIdExpedientOrigen(dadesExpedientBDTOOrigen.getExpedientsRDTO().getId());
			docsAssociatsIntra.setIdExpedientDestino(dadesExpedientBDTODestino.getExpedientsRDTO().getId());
			DocsAssociatsIntraBDTO docsAssociatsIntraBDTO = new DocsAssociatsIntraBDTO(docsAssociatsIntra);
			serveisService.associatsDocsIntra(docsAssociatsIntraBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("obtenirDocumentIntraoperabilitat(String, String, DocumentIntraoperabilitatRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("obtenirDocumentIntraoperabilitat(String, String, DocumentIntraoperabilitatRDTO)", e);
			// $NON-NLS-1$

			if (e.getMessage().equalsIgnoreCase("No s'ha pogut emmagatzemar el fitxer")) {
				respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_OBTENIR_DOCUMENT_INTRAOPERABILITAT,
				        ErrorPrincipal.ERROR_DOCUMENTS_EMMAGATZEMAR_FITXER);
			} else {
				respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_OBTENIR_DOCUMENT_INTRAOPERABILITAT,
				        ErrorPrincipal.ERROR_GENERIC);
			}
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/" + idDocument + "/intraoperabilitat");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Obtenir un document per intraoperabilitat");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, documentIntraoperabilitatRDTO, respostaResultatBDTO, ex);
		}

		RespostaObtenirDocumentEntradaIntraoperabilitatExpedientRDTO respostaObtenirDocumentEntradaIntraoperabilitatExpedientRDTO = new RespostaObtenirDocumentEntradaIntraoperabilitatExpedientRDTO(
		        docsEntradaRDTOResult, dadesExpedientBDTODestino != null ? dadesExpedientBDTODestino.getExpedientsRDTO() : null,
		        registreAssentamentRDTO, respostaResultatBDTO);
		respostaObtenirDocumentIntraoperabilitatRDTO = modelMapper.map(respostaObtenirDocumentEntradaIntraoperabilitatExpedientRDTO,
		        RespostaObtenirDocumentIntraoperabilitatRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("obtenirDocumentIntraoperabilitat(String, String, DocumentIntraoperabilitatRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaObtenirDocumentIntraoperabilitatRDTO;
	}

	/**
	 * Revisar solicitud expedient.
	 *
	 * @param expedientRevisar
	 *            the expedient revisar
	 * @return the resposta revisar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients")
	@ApiOperation(nickname = "iniciarRevisioExpedientTramitadors", value = "Revisar una sol·licitud d'un expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaRevisarExpedientRDTO iniciarRevisioExpedient(
	        @ApiParam(value = "Dades de la revisió de l'expedient") @RequestBody ExpedientRevisarRDTO expedientRevisar)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("revisarSolicitudExpedient(ExpedientRevisarRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaRevisarExpedientRDTO respostaRevisarSolicitudsRDTO = null;
		ExpedientsRDTO returnExpedientsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REVISAR_EXPEDIENT);
		try {
			// El id del procedimiento debe existir y el procedimiento debe
			// encontrarse en estado Publicat
			DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
			        .consultarDadesBasiquesProcediment(expedientRevisar.getProcediment().getId());
			ServeisRestControllerValidationHelper.validateProcedimentCrearSolicitudExpedient(dadesProcedimentBDTO);

			// se valida que si la relacion es de persona interesada, solo
			// permita valores sollicitant y representant
			ServeisRestControllerValidationHelper.validatePersonesInteressadesExpedient(expedientRevisar.getPersonesInteressades(),
			        Resultat.ERROR_REVISAR_EXPEDIENT);

			// 1 - validar que la persona logueada esta dentro de los
			// interesados
			// 2 - validar que si hay lista de implicados, tengan
			// relacioTerceraPersona y coincida alguna definida en el
			// procedimiento
			// ServeisRestControllerValidationHelper.validateUsuariLogueadoInteressadesExpedient(expedientRevisar.getPersonesInteressades(),
			// expedientRevisar.getSollicitant(),
			// expedientRevisar.getRepresentant(),
			// Resultat.ERROR_REVISAR_EXPEDIENT);
			// ServeisRestControllerValidationHelper.validateTerceresPersonesProcediment(expedientRevisar.getPersonesImplicades(),
			// dadesProcedimentBDTO, Resultat.ERROR_REVISAR_EXPEDIENT);

			// El codi de la unitat gestora, opcional, debe existir y estar
			// vigente
			BigDecimal idUnitatGestora = null;
			if (expedientRevisar.getUnitatGestora() != null) {
				UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(
				        expedientRevisar.getUnitatGestora().getCodi());
				UnitatsGestoresRDTO unitatsGestoresRDTO = serveisService.consultarDadesUnitatGestora(unitatsGestoresCercaBDTO);
				ServeisRestControllerValidationHelper.validateUnitatGestora(unitatsGestoresRDTO, dadesProcedimentBDTO,
				        Resultat.ERROR_REVISAR_EXPEDIENT);
				idUnitatGestora = unitatsGestoresRDTO.getId();
			} else {
				// Si no se indica, se establece la UGR del procedimiento
				idUnitatGestora = dadesProcedimentBDTO.getProcedimentsRDTO().getUgrIdext();
			}

			ExpedientsRDTO expedientsRDTO = modelMapper.map(expedientRevisar, ExpedientsRDTO.class);
			// Se debe indicar el id de la Unitat Gestora recuperada
			expedientsRDTO.setUnitatGestoraIdext(idUnitatGestora);
			ExpedientsCrearBDTO expedientsCrearBDTO = new ExpedientsCrearBDTO(expedientsRDTO);

			if (StringUtils.isNotEmpty(expedientRevisar.getNumeroRegistre())) {
				Sollicituds sollicituds = new Sollicituds();
				es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentament registreAssentament = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentament();
				registreAssentament.setCodi(expedientRevisar.getNumeroRegistre());
				sollicituds.setRegistreAssentament(registreAssentament);
				expedientsCrearBDTO.getExpedientsRDTO().setSollicituds(sollicituds);
			}

			returnExpedientsRDTO = serveisService.crearSollicitudExpedient(expedientsCrearBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("revisarSolicitudExpedient(ExpedientRevisarRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("revisarSolicitudExpedient(ExpedientRevisarRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_REVISAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Revisar una sol·licitud d'un expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientRevisar, respostaResultatBDTO, ex);
		}
		RespostaExpedientsCrearBDTO respostaExpedientsRevisarBDTO = new RespostaExpedientsCrearBDTO(returnExpedientsRDTO,
		        respostaResultatBDTO);
		respostaRevisarSolicitudsRDTO = modelMapper.map(respostaExpedientsRevisarBDTO, RespostaRevisarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("revisarSolicitudExpedient(SolicitudsCrearRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaRevisarSolicitudsRDTO;
	}

	/**
	 * Revisar solicitud expedient.
	 *
	 * @param recursExpedient
	 *            the recurs expedient
	 * @return the resposta revisar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/recurs")
	@ApiOperation(nickname = "presentarRecursExpedientTramitadors", value = "Revisar una sol·licitud d'un expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaRecursExpedientRDTO presentarRecursExpedient(
	        @ApiParam(value = "Dades de la revisió de l'expedient") @RequestBody RecursExpedientRDTO recursExpedient)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("presentarRecursExpedient(RecursExpedientRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaRecursExpedientRDTO respostaRecursExpedientRDTO = null;
		ExpedientsRDTO returnExpedientsRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_RECURS_EXPEDIENT);
		try {
			// El id del procedimiento debe existir y el procedimiento debe
			// encontrarse en estado Publicat
			DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
			        .consultarDadesBasiquesProcediment(recursExpedient.getProcediment().getId());
			ServeisRestControllerValidationHelper.validateProcedimentCrearSolicitudExpedient(dadesProcedimentBDTO);

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper
			        .getCodiInternalValue(recursExpedient.getExpedientObjecteDeRecurs(), expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_RECURS_EXPEDIENT);
			// La acción debe estar disponible: estats posibles [Finalizat y
			// comunicat, tancat]
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.PRESENTAR_RECURS, Resultat.ERROR_RECURS_EXPEDIENT);

			// El codi de la unitat gestora, opcional, debe existir y estar
			// vigente
			BigDecimal idUnitatGestora = null;
			if (recursExpedient.getUnitatGestora() != null) {
				UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(
				        recursExpedient.getUnitatGestora().getCodi());
				UnitatsGestoresRDTO unitatsGestoresRDTO = serveisService.consultarDadesUnitatGestora(unitatsGestoresCercaBDTO);
				ServeisRestControllerValidationHelper.validateUnitatGestora(unitatsGestoresRDTO, dadesProcedimentBDTO,
				        Resultat.ERROR_RECURS_EXPEDIENT);
				idUnitatGestora = unitatsGestoresRDTO.getId();
			} else {
				// Si no se indica, se establece la UGR del procedimiento
				idUnitatGestora = dadesProcedimentBDTO.getProcedimentsRDTO().getUgrIdext();
			}

			ExpedientsRDTO expedientsRDTO = modelMapper.map(recursExpedient, ExpedientsRDTO.class);
			// Se debe indicar el id de la Unitat Gestora recuperada
			expedientsRDTO.setUnitatGestoraIdext(idUnitatGestora);
			// Indicamos también el id del expediente objeto de recurso
			expedientsRDTO.setExpedientObjecteDeRecursId(dadesExpedientBDTO.getExpedientsRDTO().getId());

			ExpedientsCrearBDTO expedientsCrearBDTO = new ExpedientsCrearBDTO(expedientsRDTO);
			returnExpedientsRDTO = serveisService.crearSollicitudExpedient(expedientsCrearBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("revisarSolicitudExpedient(ExpedientRevisarRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("revisarSolicitudExpedient(ExpedientRevisarRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_RECURS_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/recurs");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Presentar recurs d'un expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, recursExpedient, respostaResultatBDTO, ex);
		}

		RespostaExpedientsCrearBDTO respostaRecursExpedientsBDTO = new RespostaExpedientsCrearBDTO(returnExpedientsRDTO,
		        respostaResultatBDTO);
		respostaRecursExpedientRDTO = modelMapper.map(respostaRecursExpedientsBDTO, RespostaRecursExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("revisarSolicitudExpedient(SolicitudsCrearRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaRecursExpedientRDTO;
	}

	/**
	 * Actualitzar solicitud expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param solicitudExpedient
	 *            the solicitud expedient
	 * @return the resposta actualitzar expedient RDTO
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/expedients/{codiExpedient}")
	@ApiOperation(nickname = "actualitzarSolicitudExpedientTramitadors", value = "Actualitzar dades de la sol·licitud de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaActualitzarExpedientRDTO actualitzarSolicitudExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la actualització de l'expedient") @RequestBody ExpedientActualitzarRDTO solicitudExpedient)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		ImiUserDetails imiUser = SecurityUtils.getLoggedUserDetails();
		String userInfo = imiUser != null ? imiUser.getPayload() : "Sin usuario";
		if (log.isInfoEnabled()) {
			log.info("SEGUIMIENTO USUARIO SSO actualitzarSolicitudExpedient (RestController): " + userInfo);
		}

		RespostaActualitzarExpedientRDTO respostaActualitzarSolicitudsRDTO = null;
		ExpedientsRDTO returnExpedientsRDTO = null;
		RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACTUALITZAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			DadesExpedientBDTO dadesExpedientBDTO = serveisService.consultarDadesBasiquesPerVisibilitatExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

			// Si se indica alguna persona al menos debe indicarse el
			// Solicitante
			ServeisRestControllerValidationHelper.validateSollicitantActualitzarSolicitudExpedient(solicitudExpedient.getSollicitant(),
			        solicitudExpedient.getRepresentant());

			// se valida que si la relacion es de persona interesada, solo
			// permita valores sollicitant y representant
			ServeisRestControllerValidationHelper.validatePersonesInteressadesExpedient(solicitudExpedient.getPersonesInteressades(),
			        Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

			// Actualizar Solicitante / Representante / Dades d'Operació si se
			// incluyen en los datos de la petición y si la acción es permitida
			if (solicitudExpedient.getSollicitant() != null || CollectionUtils.isNotEmpty(solicitudExpedient.getDadesOperacio())) {
				ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
				        AccioTramitadorApiParamValue.INFORMAR_DADES_EXPEDIENT, Resultat.ERROR_ACTUALITZAR_EXPEDIENT);
			}

			// Se obtienen los Dades d'Operació del procedimiento y se valida
			// que los códigos indicados existen. Se aprovecha para recuperar
			// los identificadores de los campos
			ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;
			if (CollectionUtils.isNotEmpty(solicitudExpedient.getDadesOperacio())) {
				DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
				respostaDadesOperacioCercaBDTO = serveisService.cercaDadesOperacio(dadesOperacioCercaBDTO);
				dadesEspecifiquesRDTOList = ServeisRestControllerValidationHelper.validateDadesOperacioActualitzarSolicitudExpedient(
				        solicitudExpedient.getDadesOperacio(), respostaDadesOperacioCercaBDTO.getDadesGrupsRDTOList(),
				        dadesExpedientBDTO.getExpedientsRDTO().getId(), null, false);
			}

			// 1 - validamos que el usuario logado pertenezca al expediente
			// 2 - validamos si es tercera persona su visibilidad
			// ServeisRestControllerVisibilitatHelper.validateVisibilitatTerceresPersones(serveisService,
			// respostaDadesOperacioCercaBDTO, null,
			// dadesExpedientBDTO, Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

			// Se construye el modelo para la llamada a la operación de
			// actualización
			ExpedientsRDTO expedientsRDTO = modelMapper.map(solicitudExpedient, ExpedientsRDTO.class);
			// Se indica el id del Expediente recibido como path variable
			expedientsRDTO.setId(dadesExpedientBDTO.getExpedientsRDTO().getId());
			ActualitzarDadesSollicitud actualitzarDadesSollicitud = new ActualitzarDadesSollicitud();
			actualitzarDadesSollicitud.setExpedient(expedientsRDTO);
			actualitzarDadesSollicitud.setDadesEspecifiques(dadesEspecifiquesRDTOList);
			actualitzarDadesSollicitud.setTipusIniciacio(solicitudExpedient.getTipusIniciacio());
			ExpedientsActualitzarBDTO expedientsActualitzarBDTO = new ExpedientsActualitzarBDTO(actualitzarDadesSollicitud);
			returnExpedientsRDTO = serveisService.actualitzarSolicitudExpedient(expedientsActualitzarBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient);
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Actualitzar dades de la sol·licitud de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, solicitudExpedient, respostaResultatBDTO, ex);
		}

		RespostaExpedientsActualitzarBDTO respostaExpedientsActualitzarBDTO = new RespostaExpedientsActualitzarBDTO(returnExpedientsRDTO,
		        respostaResultatBDTO);
		respostaActualitzarSolicitudsRDTO = modelMapper.map(respostaExpedientsActualitzarBDTO, RespostaActualitzarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitudExpedient(BigDecimal, SolicitudsActualitzarRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaActualitzarSolicitudsRDTO;
	}

	/**
	 * Publicar per A informacio publica.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param informacioPublicaRDTO
	 *            the informacio publica RDTO
	 * @return the resposta publicar per A informacio publica RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/publicar")
	@ApiOperation(nickname = "publicarPerAInformacioPublicaTramitadors", value = "Publicar per a informació pública", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaPublicarPerAInformacioPublicaRDTO publicarPerAInformacioPublica(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades per a la informació pública") @RequestBody InformacioPublicaRDTO informacioPublicaRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("publicarPerAInformacioPublica(String, InformacioPublicaRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaPublicarPerAInformacioPublicaRDTO respostaPublicarPerAInformacioPublicaRDTO = null;
		ExpedientsRDTO returnExpedientsRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PUBLICAR_PER_A_INFORMACIO_PUBLICA);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_PUBLICAR_PER_A_INFORMACIO_PUBLICA);

			// TODO ver la información que se debe enviar, validaciones y hacer
			// la integración

		} catch (GPAApiParamValidationException e) {
			log.error("publicarPerAInformacioPublica(String, InformacioPublicaRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("publicarPerAInformacioPublica(String, InformacioPublicaRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_PUBLICAR_PER_A_INFORMACIO_PUBLICA,
			        e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/publicar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Publicar per a informació pública");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, informacioPublicaRDTO, respostaResultatBDTO, ex);
		}

		RespostaPublicarPerAInformacioPublicaBDTO respostaPublicarPerAInformacioPublicaBDTO = new RespostaPublicarPerAInformacioPublicaBDTO(
		        returnExpedientsRDTO, respostaResultatBDTO);
		respostaPublicarPerAInformacioPublicaRDTO = modelMapper.map(respostaPublicarPerAInformacioPublicaBDTO,
		        RespostaPublicarPerAInformacioPublicaRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("publicarPerAInformacioPublica(String, InformacioPublicaRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaPublicarPerAInformacioPublicaRDTO;
	}

	/**
	 * Anotar operacio comptable.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param operacioComptableRDTO
	 *            the operacio comptable RDTO
	 * @return the resposta anotar operacio comptable RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/operacioComptable/anotar")
	@ApiOperation(nickname = "anotarOperacioComptableTramitadors", value = "Anotar Operació comptable", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAnotarOperacioComptableRDTO anotarOperacioComptable(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de l'operació comptable") @RequestBody OperacioComptableRDTO operacioComptableRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("anotarOperacioComptable(String, OperacioComptableRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaAnotarOperacioComptableRDTO respostaAnotarOperacioComptableRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ANOTAR_OPERACIO_COMPTABLE);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ANOTAR_OPERACIO_COMPTABLE);

			// TODO ver la información que se debe enviar, validaciones y hacer
			// la integración

			AnotarOperacioComptableRDTO anotarOperacioComptableRDTO = new AnotarOperacioComptableRDTO();
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(operacioComptableRDTO.getComentari());
			anotarOperacioComptableRDTO.setComentari(comentaris);

			AnotarOperacioComptableBDTO anotarOperacioComptableBDTO = new AnotarOperacioComptableBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), anotarOperacioComptableRDTO);
			serveisService.anotarOperacioComptable(anotarOperacioComptableBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("anotarOperacioComptable(String, OperacioComptableRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("anotarOperacioComptable(String, OperacioComptableRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ANOTAR_OPERACIO_COMPTABLE, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/operacioComptable/anotar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Anotar Operació comptable");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, operacioComptableRDTO, respostaResultatBDTO, ex);
		}

		RespostaAnotarOperacioComptableBDTO respostaAnotarOperacioComptableBDTO = new RespostaAnotarOperacioComptableBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaAnotarOperacioComptableRDTO = modelMapper.map(respostaAnotarOperacioComptableBDTO,
		        RespostaAnotarOperacioComptableRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("publicarPerAInformacioPublica(String, OperacioComptableRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaAnotarOperacioComptableRDTO;
	}

	/**
	 * Inscriure en registre.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param inscriureRegistreRDTO
	 *            the inscriure registre RDTO
	 * @return the resposta inscriure en registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/registre/inscriure")
	@ApiOperation(nickname = "inscriureEnRegistreTramitadors", value = "Inscriure en un registre", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaInscriureEnRegistreRDTO inscriureEnRegistre(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades del registre") @RequestBody InscriureRegistreRDTO inscriureRegistreRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("inscriureEnRegistre(String, InscriureEnRegistreRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaInscriureEnRegistreRDTO respostaInscriureEnRegistreRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_INSCRIURE_EN_REGISTRE);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_INSCRIURE_EN_REGISTRE);

			// TODO ver la información que se debe enviar, validaciones y hacer
			// la integración

			InscriureEnRegistreRDTO inscriureEnRegistreRDTO = new InscriureEnRegistreRDTO();
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(inscriureRegistreRDTO.getComentari());
			inscriureEnRegistreRDTO.setComentari(comentaris);

			InscriureEnRegistreBDTO inscriureEnRegistreBDTO = new InscriureEnRegistreBDTO(dadesExpedientBDTO.getExpedientsRDTO().getId(),
			        inscriureEnRegistreRDTO);
			serveisService.inscriureEnRegistre(inscriureEnRegistreBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("inscriureEnRegistre(String, InscriureEnRegistreRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("inscriureEnRegistre(String, InscriureEnRegistreRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_INSCRIURE_EN_REGISTRE, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/registre/inscriure");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Inscriure en un registre");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, inscriureRegistreRDTO, respostaResultatBDTO, ex);
		}

		RespostaInscriureEnRegistreBDTO respostaInscriureEnRegistreBDTO = new RespostaInscriureEnRegistreBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaInscriureEnRegistreRDTO = modelMapper.map(respostaInscriureEnRegistreBDTO, RespostaInscriureEnRegistreRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("inscriureEnRegistre(String, InscriureEnRegistreRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaInscriureEnRegistreRDTO;
	}

	/**
	 * Esborrar document.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param documentacioEsborrarRDTO
	 *            the documentacio esborrar RDTO
	 * @return the resposta esborrar document RDTO
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/esborrar")
	@ApiOperation(nickname = "esborrarDocumentTramitadors", value = "Esborrar un document de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaEsborrarDocumentRDTO esborrarDocument(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Dades del document a esborrar") @RequestBody DocumentacioEsborrarRDTO documentacioEsborrarRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("esborrarDocument(String, BigDecimal, String) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaEsborrarDocumentRDTO respostaEsborrarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		DocsTramitacioRDTO docsTramitacioRDTO = null;
		Boolean esAportada = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ESBORRAR_DOCUMENT);

		try {

			ConfiguracioApiParamValueTranslator configuracioApiParamValueTranslator = new ConfiguracioApiParamValueTranslator();
			ConfiguracioApiParamValue configuracioApiParamValue = configuracioApiParamValueTranslator
			        .getEnumByApiParamValue(documentacioEsborrarRDTO.getConfiguracio());
			switch (configuracioApiParamValue) {
			case APORTADA:
				esAportada = Boolean.TRUE;

				break;
			case GENERADA:
				esAportada = Boolean.FALSE;

				break;
			default:
				break;
			}

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ESBORRAR_DOCUMENT);

			// Esborrar document si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.ESBORRAR_DOCUMENT, Resultat.ERROR_ESBORRAR_DOCUMENT);

			if (esAportada) {
				// El id del documento debe existir y pertenecer al expediente
				// indicado
				docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
				ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO.getExpedientsRDTO(),
				        Resultat.ERROR_ESBORRAR_DOCUMENT);

				ServeisRestControllerValidationHelper.validateDocumentAportatEsborrar(docsEntradaRDTO, dadesExpedientBDTO,
				        Resultat.ERROR_ESBORRAR_DOCUMENT);

				// Se construye el modelo para la llamada a la operación de
				// esborrar
				// document
				EsborrarDocumentBDTO esborrarDocumentBDTO = new EsborrarDocumentBDTO(dadesExpedientBDTO.getExpedientsRDTO().getId(),
				        idDocument);

				serveisService.esBorrarDocumentacioEntrada(esborrarDocumentBDTO);
			} else {
				// El id del documento debe existir y pertenecer al expediente
				// indicado
				docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocument);
				ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
				        Resultat.ERROR_ESBORRAR_DOCUMENT);

				ServeisRestControllerValidationHelper.validateDocumentGeneratEsborrar(docsTramitacioRDTO, dadesExpedientBDTO,
				        Resultat.ERROR_ESBORRAR_DOCUMENT);

				// Se construye el modelo para la llamada a la operación de
				// esborrar
				// document
				EsborrarDocumentBDTO esborrarDocumentBDTO = new EsborrarDocumentBDTO(dadesExpedientBDTO.getExpedientsRDTO().getId(),
				        idDocument);

				serveisService.esBorrarDocumentacioTramitacio(esborrarDocumentBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("esborrarDocument(BigDecimal, BigDecimal)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("esborrarDocument(BigDecimal, BigDecimal)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ESBORRAR_DOCUMENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/" + idDocument + "/esborrar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Esborrar un document de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, documentacioEsborrarRDTO, respostaResultatBDTO, ex);
		}

		ExpedientsRDTO expedientsRDTO = (dadesExpedientBDTO != null) ? dadesExpedientBDTO.getExpedientsRDTO() : null;

		if (esAportada) {
			RespostaEsborrarDocumentEntradaBDTO respostaEsborrarDocumentEntradaBDTO = new RespostaEsborrarDocumentEntradaBDTO(
			        expedientsRDTO, docsEntradaRDTO, respostaResultatBDTO);
			respostaEsborrarDocumentRDTO = modelMapper.map(respostaEsborrarDocumentEntradaBDTO, RespostaEsborrarDocumentRDTO.class);
		} else {
			RespostaEsborrarDocumentTramitacioBDTO respostaEsborrarDocumentTramitacioBDTO = new RespostaEsborrarDocumentTramitacioBDTO(
			        expedientsRDTO, docsTramitacioRDTO, respostaResultatBDTO);
			respostaEsborrarDocumentRDTO = modelMapper.map(respostaEsborrarDocumentTramitacioBDTO, RespostaEsborrarDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("esborrarDocument(String, BigDecimal, String) - fi"); //$NON-NLS-1$
		}
		return respostaEsborrarDocumentRDTO;
	}

	/**
	 * Abandonar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param accio
	 *            the accio
	 * @param expedientAbandonament
	 *            the expedient abandonament
	 * @return the resposta abandonar expedient RDTO
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/expedients/{codiExpedient}/abandonar")
	@ApiOperation(nickname = "abandonarExpedientTramitadors", value = "Desistir/Renunciar l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAbandonarExpedientRDTO abandonarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades del abandonament de l'expedient") @RequestBody ExpedientAbandonamentRDTO expedientAbandonament)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("abandonarExpedient(BigDecimal, String, ExpedientAbandonamentRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaAbandonarExpedientRDTO respostaAbandonarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_DESISTIR_RENUNCIAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT);

			// Registrar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR, Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(), ExpedientCanviEstat.class);
			expedientCanviEstat.setComentari(expedientAbandonament.getComentari());

			// obtenemos el idAccioEstat futuro
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
			        AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR.getInternalValue(),
			        dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());

			// debe existir una transicion posible para el estado actual
			ServeisRestControllerValidationHelper.validateTransicioAccioDisponibleExpedient(accionsEstatsRDTOList,
			        AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR, Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT);

			expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

			ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());
			serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientAbandonament.getComentari());
			comentariCreacioAccio.setOperacio(AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR.getApiParamValue());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

			// Crear aviso
			// TODO se comenta ya que no se debe crear el aviso
			/*
			 * AvisCreacioAccio avisCreacioAccio = new AvisCreacioAccio();
			 * avisCreacioAccio.setOperacio(AccioTramitadorApiParamValue.
			 * DESISTIR_RENUNCIAR.getApiParamValue()); AvisosCrearAccioBDTO
			 * avisosCrearAccioBDTO = new AvisosCrearAccioBDTO(avisCreacioAccio,
			 * dadesExpedientBDTO.getExpedientsRDTO().getId(),
			 * AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR.getInternalValue(
			 * )); serveisService.crearAvisAccio(avisosCrearAccioBDTO);
			 */

		} catch (GPAApiParamValidationException e) {
			log.error("abandonarExpedient(BigDecimal, String, ExpedientAbandonamentRDTO)", e);// $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("abandonarExpedient(BigDecimal, String, ExpedientAbandonamentRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/abandonar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Desistir/Renunciar l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, expedientAbandonament, respostaResultatBDTO, ex);
		}

		RespostaExpedientsAbandonarBDTO respostaExpedientsAbandonarBDTO = new RespostaExpedientsAbandonarBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaAbandonarExpedientRDTO = modelMapper.map(respostaExpedientsAbandonarBDTO, RespostaAbandonarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("abandonarExpedient(BigDecimal, String, ExpedientAbandonamentRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaAbandonarExpedientRDTO;
	}

	@PostMapping(value = "/expedients/{codiExpedient}/interoperabilitat")
	@ApiOperation(nickname = "obtenirPerInteroperabilitatTramitadors", value = "Obtenir un document per interoperabilitat", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaObtenirPerInteroperabilitatRDTO obtenirPerInteroperabilitat(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades necessàries per a la consulta al servei", required = true) @RequestBody ObtenirPerInteroperabilitatRDTO obtenirPerInteroperabilitatRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obtenirPerInteroperabilitat(String, ObtenirPerInteroperabilitatRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaObtenirPerInteroperabilitatRDTO respostaObtenirPerInteroperabilitatRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		String resposta = null;
		RespostaInteroperabilitat respostaInteroperabilitat = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_OBTENIR_PER_INTEROPERABILITAT);

		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_OBTENIR_PER_INTEROPERABILITAT);

			ObtenirPerInteroperabilitat obtenirPerInteroperabilitat = new ObtenirPerInteroperabilitat();
			obtenirPerInteroperabilitat.setCodiServei(obtenirPerInteroperabilitatRDTO.getCodiServei());

			ObtenirPerInteroperabilitatBDTO obtenirPerInteroperabilitatBDTO = new ObtenirPerInteroperabilitatBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), obtenirPerInteroperabilitat);

			respostaInteroperabilitat = serveisService.obtenirPerInteroperabilitat(obtenirPerInteroperabilitatBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("obtenirPerInteroperabilitat(String, ObtenirPerInteroperabilitatRDTO) ", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("obtenirPerInteroperabilitat(String, ObtenirPerInteroperabilitatRDTO) ", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_OBTENIR_PER_INTEROPERABILITAT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/interoperabilitat");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Obtenir un document per interoperabilitat");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, obtenirPerInteroperabilitatRDTO, respostaResultatBDTO,
			        ex);
		}

		switch (obtenirPerInteroperabilitatRDTO.getCodiServei()) {
		case "DGT - Verificació matrícula":
			if (respostaInteroperabilitat != null && respostaInteroperabilitat.getRespostaServeiDgt() != null) {
				resposta = respostaInteroperabilitat.getRespostaServeiDgt().getIdentificadorPropietari();
			}
			break;
		}
		RespostaObtenirPerInteroperabilitatBDTO respostaObtenirPerInteroperabilitatBDTO = new RespostaObtenirPerInteroperabilitatBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO, resposta);

		respostaObtenirPerInteroperabilitatRDTO = modelMapper.map(respostaObtenirPerInteroperabilitatBDTO,
		        RespostaObtenirPerInteroperabilitatRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("obtenirPerInteroperabilitat(String, ObtenirPerInteroperabilitatRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaObtenirPerInteroperabilitatRDTO;
	}

	/**
	 * Obtenir certificat expedients.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the resposta certificar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping(value = "/expedients/{codiExpedient}/obtenirCertificat")
	@ApiOperation(nickname = "obtenirCertificatTramitadors", value = "Obtenir certificat", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaCertificarExpedientRDTO obtenirCertificat(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obtenirCertificat(String) - inici"); //$NON-NLS-1$
		}

		// TODO Integración pendiente
		CertificarExpedientRDTO certificarExpedientRDTO = new CertificarExpedientRDTO();

		if (log.isDebugEnabled()) {
			log.debug("obtenirCertificat(String) - fi"); //$NON-NLS-1$
		}

		return new RespostaCertificarExpedientRDTO();
	}

	/**
	 * Digitalitzar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param documentDigitalitzacio
	 *            the document digitalitzacio
	 * @return the resposta digitalitzar document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/digitalitzar")
	@ApiOperation(nickname = "digitalitzarDocumentExpedientTramitadors", value = "Força el canvi d'estat de l'expedient a Finzalizado i Comunicat després de la signatura dels documents", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaDigitalitzarDocumentRDTO digitalitzarDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la digitalització del document de l'expedient") @RequestBody DocumentDigitalitzacioRDTO documentDigitalitzacio)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("digitalitzarDocumentExpedient(String, DocumentDigitalitzacioRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaDigitalitzarDocumentRDTO respostaDigitalitzarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RegistreAssentamentRDTO registreAssentamentRDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		DocsTramitacioRDTO docsTramitacioRDTOResult = null;
		Boolean esAportada = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_DOCUMENT_DIGITALITZAT_EXPEDIENT);
		try {
			ConfiguracioApiParamValueTranslator configuracioApiParamValueTranslator = new ConfiguracioApiParamValueTranslator();
			ConfiguracioApiParamValue configuracioApiParamValue = configuracioApiParamValueTranslator
			        .getEnumByApiParamValue(documentDigitalitzacio.getDocument().getConfiguracio());
			switch (configuracioApiParamValue) {
			case APORTADA:
				esAportada = Boolean.TRUE;
				break;
			case GENERADA:
				esAportada = Boolean.FALSE;
				break;
			default:
				break;
			}

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT);

			// El número de registro indicado debe existir
			if (esAportada) {
				// El número de registro indicado debe existir
				registreAssentamentRDTO = serveisService
				        .consultarDadesRegistreAssentament(documentDigitalitzacio.getDocument().getNumeroRegistre());
				ServeisRestControllerValidationHelper.validateRegistreAssentament(registreAssentamentRDTO,
				        Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT);
			}

			// Digitalizar documento si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.DIGITALITZAR_DOCUMENT, Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT);

			// Digitalizar un documento, pudiéndose tratar de entrada o
			// tramitación
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			if (BooleanUtils.isTrue(esAportada)) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
				HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioEntradaDigitalitzar(
				                respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
				                documentDigitalitzacio.getDocument(), Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT);

				DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentDigitalitzacio.getDocument(), DocsEntradaRDTO.class);
				docsEntradaRDTO
				        .setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());

				if (registreAssentamentRDTO != null) {
					RegistreAssentament registreAssentament = new RegistreAssentament();
					registreAssentament.setId(registreAssentamentRDTO.getId());
					docsEntradaRDTO.setRegistreAssentament(registreAssentament);
				}

				CrearDocumentEntradaDigitalitzarBDTO crearDocumentEntradaDigitalitzarBDTO = new CrearDocumentEntradaDigitalitzarBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
				// TODO ¿Se crea un documento por cada uno de los códigos de
				// Gestor Documental obtenidos?
				for (String codi : documentDigitalitzacio.getDocument().getCodis()) {
					crearDocumentEntradaDigitalitzarBDTO.getDocsEntradaRDTO().setCodi(codi);
					crearDocumentEntradaDigitalitzarBDTO.getDocsEntradaRDTO().setMigracioIdOrigen(codi);
					docsEntradaRDTOResult = serveisService.crearDocumentEntradaDigitalitzat(crearDocumentEntradaDigitalitzarBDTO);
				}
			} else {
				DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
				RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
				HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioTramitacioDigitalitzar(
				                respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
				                documentDigitalitzacio.getDocument(), Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT);

				DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(documentDigitalitzacio.getDocument(), DocsTramitacioRDTO.class);
				docsTramitacioRDTO.setConfigDocTramitacio(
				        configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());

				CrearDocumentTramitacioDigitalitzarBDTO crearDocumentTramitacioDigitalitzarBDTO = new CrearDocumentTramitacioDigitalitzarBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getId(), docsTramitacioRDTO);
				// TODO ¿Se crea un documento por cada uno de los códigos de
				// Gestor Documental obtenidos?
				for (String codi : documentDigitalitzacio.getDocument().getCodis()) {
					crearDocumentTramitacioDigitalitzarBDTO.getDocsTramitacioRDTO().setCodi(codi);
					docsTramitacioRDTOResult = serveisService.crearDocumentTramitacioDigitalitzat(crearDocumentTramitacioDigitalitzarBDTO);
				}
			}

		} catch (GPAApiParamValidationException e) {
			log.error("digitalitzarDocumentExpedient(String, DocumentDigitalitzacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("digitalitzarDocumentExpedient(String, DocumentDigitalitzacioRDTO)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/documentacio/digitalitzar");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio(
			        "Força el canvi d'estat de l'expedient a Finzalizado i Comunicat després de la signatura dels documents");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, documentDigitalitzacio, respostaResultatBDTO, ex);
		}

		if (BooleanUtils.isTrue(esAportada)) {
			RespostaDigitalitzarDocumentEntradaBDTO respostaDigitalitzarDocumentExpedientBDTO = new RespostaDigitalitzarDocumentEntradaBDTO(
			        docsEntradaRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
			        registreAssentamentRDTO, respostaResultatBDTO);
			respostaDigitalitzarDocumentRDTO = modelMapper.map(respostaDigitalitzarDocumentExpedientBDTO,
			        RespostaDigitalitzarDocumentRDTO.class);
		} else {
			RespostaDigitalitzarDocumentTramitacioBDTO respostaDigitalitzarDocumentTramitacioBDTO = new RespostaDigitalitzarDocumentTramitacioBDTO(
			        docsTramitacioRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
			        registreAssentamentRDTO, respostaResultatBDTO);
			respostaDigitalitzarDocumentRDTO = modelMapper.map(respostaDigitalitzarDocumentTramitacioBDTO,
			        RespostaDigitalitzarDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("digitalitzarDocumentExpedient(String, DocumentDigitalitzacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaDigitalitzarDocumentRDTO;
	}
	
	private void logImiUser() {
		if (log.isInfoEnabled()) {
			ImiUserDetails imiUser = SecurityUtils.getLoggedUserDetails();
			log.info(String.format("---------> ImiUserDetails: %s", imiUser)); //$NON-NLS-1$Imi
			if (imiUser != null) {
				log.info(String.format("---------> imiUser.getPayload(): %s", imiUser.getPayload())); //$NON-NLS-1$Imi
			}else{
				log.info("---------> imiUser nulo"); //$NON-NLS-1$Imi
			}
			
		}
	}

	/**
	 * Incorporar tercera persona
	 * 
	 * @param codiExpedient
	 * @param personaImplicada
	 * @return
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/expedients/{codiExpedient}/persones")
	@ApiOperation(nickname = "incorporarTerceraPersonaTramitadors", value = "Incorporar tercera persona a la sol·licitud de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaCrearTerceraPersonaRDTO incorporarTerceraPersona(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la actualització de l'expedient", required = true) @RequestBody CrearTerceraPersonaRDTO personaImplicada)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("incorporarTerceraPersona(BigDecimal, CrearTerceraPersonaRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaCrearTerceraPersonaRDTO respostaCrearTerceraPersonaRDTO = null;
		PersonesSollicitudRDTO returnPersonesSollicitudRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		TerceraPersonaSollicitudRDTO terceraPersonaSollicitudRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_INCORPORAR_TERCERA_PERSONA_EXPEDIENT);
		try {
			// El codi del expediente debe existir ( se consultan mas datos que
			// luego son necesarios para comprobar la persona existente en el
			// expediente)
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesPerVisibilitatExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO,
			        Resultat.ERROR_INCORPORAR_TERCERA_PERSONA_EXPEDIENT);

			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.INFORMAR_DADES_EXPEDIENT, Resultat.ERROR_INCORPORAR_TERCERA_PERSONA_EXPEDIENT);

			// 1 - validamos que el usuario logado pertenezca al expediente

			// TODO validar DNI

			// Se construye el modelo para la llamada a la operación de
			// actualización
			terceraPersonaSollicitudRDTO = modelMapper.map(personaImplicada, TerceraPersonaSollicitudRDTO.class);

			terceraPersonaSollicitudRDTO.getPersonesSollicitudRDTO().setSollicitud(dadesExpedientBDTO.getExpedientsRDTO().getSollicitud());
			returnPersonesSollicitudRDTO = serveisService
			        .incorporarTerceraPersona(terceraPersonaSollicitudRDTO.getPersonesSollicitudRDTO());

		} catch (GPAApiParamValidationException e) {
			log.error("incorporarTerceraPersona(BigDecimal, CrearTerceraPersonaRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("incorporarTerceraPersona(BigDecimal, CrearTerceraPersonaRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler
			        .handleException(Resultat.ERROR_INCORPORAR_TERCERA_PERSONA_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/persones");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Incorporar tercera persona a la sol·licitud de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, personaImplicada, respostaResultatBDTO, ex);
		}

		RespostaCrearTerceraPersonaBDTO respostaCrearTerceraPersonaBDTO = new RespostaCrearTerceraPersonaBDTO(returnPersonesSollicitudRDTO,
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaCrearTerceraPersonaRDTO = modelMapper.map(respostaCrearTerceraPersonaBDTO, RespostaCrearTerceraPersonaRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("incorporarTerceraPersona(BigDecimal, CrearTerceraPersonaRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaCrearTerceraPersonaRDTO;
	}

	/**
	 * Actualitzar tercera persona
	 * 
	 * @param codiExpedient
	 * @param personaImplicada
	 * @return
	 * @throws GPAServeisServiceException
	 */
	@PutMapping("/expedients/{codiExpedient}/persones")
	@ApiOperation(nickname = "actualitzarTerceraPersonaTramitadors", value = "Actualitza tercera persona en la sol·licitud de l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaActualitzarTerceraPersonaRDTO actualitzarTerceraPersona(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la actualització de l'expedient", required = true) @RequestBody ActualitzarTerceraPersonaRDTO personaImplicada)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarTerceraPersona(BigDecimal, ActualitzarTerceraPersonaRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaActualitzarTerceraPersonaRDTO respostaActualitzarTerceraPersonaRDTO = null;
		PersonesSollicitudRDTO returnPersonesSollicitudRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		TerceraPersonaSollicitudRDTO terceraPersonaSollicitudRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACTUALITZAR_TERCERA_PERSONA_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesPerVisibilitatExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO,
			        Resultat.ERROR_ACTUALITZAR_TERCERA_PERSONA_EXPEDIENT);

			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.INFORMAR_DADES_EXPEDIENT, Resultat.ERROR_ACTUALITZAR_TERCERA_PERSONA_EXPEDIENT);

			// 1 - validamos que el usuario logado pertenezca al expediente

			// TODO validar DNI

			// Se construye el modelo para la llamada a la operación de
			// actualización
			terceraPersonaSollicitudRDTO = modelMapper.map(personaImplicada, TerceraPersonaSollicitudRDTO.class);

			terceraPersonaSollicitudRDTO.getPersonesSollicitudRDTO().setSollicitud(dadesExpedientBDTO.getExpedientsRDTO().getSollicitud());
			returnPersonesSollicitudRDTO = serveisService
			        .incorporarTerceraPersona(terceraPersonaSollicitudRDTO.getPersonesSollicitudRDTO());

		} catch (GPAApiParamValidationException e) {
			log.error("actualitzarTerceraPersona(BigDecimal, ActualitzarTerceraPersonaRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("actualitzarTerceraPersona(BigDecimal, ActualitzarTerceraPersonaRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler
			        .handleException(Resultat.ERROR_ACTUALITZAR_TERCERA_PERSONA_EXPEDIENT, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/persones");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("PUT");
			auditServeisBDTO.setValueAccio("Actualitza tercera persona en la sol·licitud de l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, personaImplicada, respostaResultatBDTO, ex);
		}

		RespostaActualitzarTerceraPersonaBDTO respostaActualitzarTerceraPersonaBDTO = new RespostaActualitzarTerceraPersonaBDTO(
		        returnPersonesSollicitudRDTO, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
		        respostaResultatBDTO);
		respostaActualitzarTerceraPersonaRDTO = modelMapper.map(respostaActualitzarTerceraPersonaBDTO,
		        RespostaActualitzarTerceraPersonaRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("actualitzarTerceraPersona(BigDecimal, ActualitzarTerceraPersonaRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaActualitzarTerceraPersonaRDTO;
	}

	/**
	 * @param idDocument
	 * @param signaturaDocument
	 * @param dadesExpedientBDTO
	 * @param peticionsPortasig
	 * @param tipusSignaturaApiParamValue
	 * @return
	 * @throws GPAServeisServiceException
	 * @throws GPAApiParamValidationException
	 */
	private PeticionsPortasig processarSignatura(BigDecimal idDocument, SignaturaDocumentRDTO signaturaDocument,
	        DadesExpedientBDTO dadesExpedientBDTO, PeticionsPortasig peticionsPortasig,
	        TipusSignaturaApiParamValue tipusSignaturaApiParamValue) throws GPAServeisServiceException, GPAApiParamValidationException {
		switch (tipusSignaturaApiParamValue) {
		case SEGELL:

			SignarSegellDocument signarSegellDocumentRDTO = new SignarSegellDocument();
			signarSegellDocumentRDTO.setIdDocument(idDocument);
			signarSegellDocumentRDTO.setPoliticaSignatura(signaturaDocument.getPoliticaSignatura());
			SignarSegellDocument signarSegellDocumentResponse = serveisService.signarSegellDocument(signarSegellDocumentRDTO);

			if (signarSegellDocumentResponse != null && StringUtils.isNotEmpty(signarSegellDocumentResponse.getDescError())) {

				// TODO Lanzar las excepciones de integración en los propios
				// módulos de integración
				StringBuilder strMessageError = new StringBuilder(Constants.MISSATGE_ERROR_SIGNATURES);
				throw new GPAServeisServiceException(strMessageError.append(": ").append(signarSegellDocumentResponse.getCodiError())
				        .append(": ").append(signarSegellDocumentResponse.getDescError()).toString());
			}

			break;

		case MANUSCRITA:

			Persones persones = serveisService.obtenirPersonaExpedientByDocumentIdentitat(dadesExpedientBDTO,
			        signaturaDocument.getUsuariManuscrita().getDocumentUsuari());

			SignarTabletDocument signarTabletDocumentRDTO = new SignarTabletDocument();
			signarTabletDocumentRDTO.setIdDocument(idDocument);
			signarTabletDocumentRDTO.setIdTabletUsuari(signaturaDocument.getUsuariManuscrita().getIdTabletUsuari());
			signarTabletDocumentRDTO.setPoliticaSignatura(signaturaDocument.getPoliticaSignatura());
			signarTabletDocumentRDTO.setNomUsuari(persones.getNomPresentacio());
			signarTabletDocumentRDTO.setDocumentIdentitatUsuari(persones.getDocumentsIdentitat().getNumeroDocument());
			signarTabletDocumentRDTO
			        .setTipusDocumentIdentitat(persones.getDocumentsIdentitat().getTipusDocumentIdentitat().getDescripcio());

			SignarTabletDocumentResponse signarTabletDocumentResponse = serveisService.signarTabletDocument(signarTabletDocumentRDTO);

			if (signarTabletDocumentResponse != null && StringUtils.isNotEmpty(signarTabletDocumentResponse.getDescError())) {

				// TODO Lanzar las excepciones de integración en los propios
				// módulos de integración
				StringBuilder strMessageError = new StringBuilder(Constants.MISSATGE_ERROR_SIGNATURES);
				throw new GPAServeisServiceException(strMessageError.append(": ").append(signarTabletDocumentResponse.getCodiError())
				        .append(": ").append(signarTabletDocumentResponse.getDescError()).toString());
			}

			break;

		case PORTASIGNATURES:
		default:

			// El usuario indicado debe existir
			UsuarisRDTO usuarisRDTO = serveisService.consultarDadesUsuari(signaturaDocument.getUsuariPortasig().getMatricula());
			ServeisRestControllerValidationHelper.validateUsuari(usuarisRDTO, Resultat.ERROR_SIGNAR_DOCUMENT);

			// Firmar documento
			UnitatsOrganigramaRDTO unitatsOrganigramaRDTO = serveisService
			        .consultarDadesUnitatOrganigrama(dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());

			SignarPortasignaturesDocument signarPortasignaturesDocument = new SignarPortasignaturesDocument();
			signarPortasignaturesDocument.setIdDocument(idDocument);
			signarPortasignaturesDocument.setAccio(TipusAccionsPortaSigApiParamValue.SIGNAR_DOCUMENT.getInternalValue());
			signarPortasignaturesDocument.setCodiUnitatOrganigrama(unitatsOrganigramaRDTO.getCodi());
			signarPortasignaturesDocument.setMatriculaUsuari(usuarisRDTO.getMatricula());
			signarPortasignaturesDocument.setNomProcediment(dadesExpedientBDTO.getExpedientsRDTO().getNomProcediment());
			signarPortasignaturesDocument.setPoliticaSignatura(signaturaDocument.getPoliticaSignatura());

			peticionsPortasig = serveisService.signarValidarDocument(signarPortasignaturesDocument);

			break;

		}
		return peticionsPortasig;
	}

	@DeleteMapping("/expedients/{codiExpedient}/persones/{idPersona}")
	@ApiOperation(nickname = "esborrarTerceraPersonaTramitadors", value = "Esborrar una persona implicada en l'expedient", tags = {
	        "Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaEsborrarTerceraPersonaRDTO esborrarTerceraPersona(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador de la persona", required = true) @PathVariable BigDecimal idPersona)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("esborrarTerceraPersona(String, BigDecimal) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaEsborrarTerceraPersonaRDTO respostaEsborrarTerceraPersonaRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DadesSollicitudBDTO dadesSollicitudBDTO = null;
		PersonesSollicitudRDTO personesSollicitudRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ESBORRAR_TERCERA_PERSONA);

		try {
			// desde tramitadors no se controla la visibilidad, solo afecta a
			// portal
			BigDecimal visibilitat = BigDecimal.ONE;

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan), visibilitat);
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ESBORRAR_TERCERA_PERSONA);

			// El id de la tercera persona debe existir y corresponderse con una
			// persona implicada en el expediente
			personesSollicitudRDTO = serveisService.consultarDadesPersonaSollicitud(idPersona);
			ServeisRestControllerValidationHelper.validatePersonaImplicadaExpedient(dadesExpedientBDTO,
			        personesSollicitudRDTO.getPersones().getDocumentsIdentitat().getNumeroDocument(),
			        Resultat.ERROR_ESBORRAR_TERCERA_PERSONA);

			// Esborrar tercera persona si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.INFORMAR_DADES_EXPEDIENT, Resultat.ERROR_ESBORRAR_TERCERA_PERSONA);

			serveisService.esborrarPersonaSollicitud(idPersona);

		} catch (GPAApiParamValidationException e) {
			log.error("esborrarTerceraPersona(String, BigDecimal)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} catch (Exception e) {
			log.error("esborrarTerceraPersona(String, BigDecimal)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ESBORRAR_TERCERA_PERSONA, e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/expedients/" + codiExpedient + "/persones/" + idPersona);
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("DELETE");
			auditServeisBDTO.setValueAccio("Esborrar una persona implicada en l'expedient");

			auditServeisService.registrarAuditServeisTramitadors(auditServeisBDTO, null, respostaResultatBDTO, ex);
		}

		ExpedientsRDTO expedientsRDTO = (dadesExpedientBDTO != null) ? dadesExpedientBDTO.getExpedientsRDTO() : null;
		RespostaEsborrarTerceraPersonaBDTO respostaEsborrarTerceraPersonaBDTO = new RespostaEsborrarTerceraPersonaBDTO(expedientsRDTO,
		        personesSollicitudRDTO, respostaResultatBDTO);
		respostaEsborrarTerceraPersonaRDTO = modelMapper.map(respostaEsborrarTerceraPersonaBDTO, RespostaEsborrarTerceraPersonaRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("esborrarTerceraPersona(String, BigDecimal) - fi"); //$NON-NLS-1$
		}
		return respostaEsborrarTerceraPersonaRDTO;
	}
}