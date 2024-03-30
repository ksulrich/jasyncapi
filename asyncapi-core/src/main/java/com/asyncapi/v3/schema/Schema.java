package com.asyncapi.v3.schema;

import com.asyncapi.v3.jackson.SchemaItemsDeserializer;
import com.asyncapi.v3.ExtendableObject;
import com.asyncapi.v3.jackson.schema.SchemasAdditionalPropertiesDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

// TODO: Finish. Not all properties are present.
// TODO: Write tests

/**
 * The Schema Object allows the definition of input and output data types. These types can be objects,
 * but also primitives and arrays. This object is a superset of the <a href="http://json-schema.org/">JSON Schema Specification Draft 07</a>.
 * <br>
 * Further information about the properties can be found in <a href="https://tools.ietf.org/html/draft-handrews-json-schema-01">JSON Schema Core</a> and <a href="https://tools.ietf.org/html/draft-handrews-json-schema-validation-01">JSON Schema Validation</a>.
 * Unless stated otherwise, the property definitions follow the JSON Schema specification as referenced here.
 * <br><br>
 * The AsyncAPI Schema Object is a JSON Schema vocabulary which extends JSON Schema Core and Validation vocabularies.
 * As such, any keyword available for those vocabularies is by definition available in AsyncAPI, and will work the
 * exact same way, including but not limited to defined properties.
 * <br><br>
 * <b>New properties may appear in this class after community requests.</b>
 *
 * @see <a href="https://json-schema.org/draft-07/schema">Draft 07 JSON Schema</a>
 * @see <a href="https://json-schema.org/draft-07/json-schema-validation">Draft 07 JSON Schema Validation</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Schema extends ExtendableObject {

    /**
     * JSON Schema ID.
     * <p>
     * format: uri-reference
     */
    @Nullable
    @JsonProperty("$id")
    @JsonPropertyDescription("JSON Schema ID.")
    public String id;

    /**
     * JSON Schema to use for validation.
     * <p>
     * format: uri
     */
    @Nullable
    @JsonProperty("$schema")
    @JsonPropertyDescription("JSON Schema to use for validation.")
    public String schema;

    /**
     * Reference to JSON Schema definition.
     * <p>
     * format: uri-reference
     */
    @Nullable
    @JsonProperty("$ref")
    @JsonPropertyDescription("Reference to JSON Schema definition.")
    private String ref;

    /**
     * JSON Schema comment.
     */
    @Nullable
    @JsonProperty("$comment")
    @JsonPropertyDescription("JSON Schema comment.")
    private String comment;

    /*
        Validation Keywords for Any Instance Type
     */

    /**
     * The value of this keyword <b>MUST</b> be either a string or an array.
     * <p>
     * If it is an array, elements of the array MUST be strings and MUST be unique.
     * <p>
     * String values MUST be one of the six primitive types:
     * <ul>
     *     <li>null</li>
     *     <li>boolean</li>
     *     <li>object</li>
     *     <li>array</li>
     *     <li>number</li>
     *     <li>string</li>
     * </ul>
     * <p>
     * or "integer" which matches any number with a zero fractional part.
     * <p>
     * An instance validates if and only if the instance is in any of the sets listed for this keyword.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.1.1">type</a>
     */
    @Nullable
    @JsonProperty("type")
    @JsonPropertyDescription("JSON Schema type.")
    public Object type;

    /**
     * The value of this keyword <b>MUST</b> be an array.
     * <p>
     * This array <b>SHOULD</b> have at least one element. Elements in the array <b>SHOULD</b> be unique.
     * <p>
     * An instance validates successfully against this keyword if its value
     * is equal to one of the elements in this keyword's array value.
     * <br>
     * Elements in the array might be of any value, including null.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.1.2">enum</a>
     */
    @Nullable
    @JsonProperty("enum")
    @JsonPropertyDescription("JSON Schema enum values.")
    public List<Object> enumValue;

    /**
     * The value of this keyword <b>MAY</b> be of any type, including null.
     * <p>
     * An instance validates successfully against this keyword if its value is equal to the value of the keyword.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.1.3">const</a>
     */
    @Nullable
    @JsonProperty("const")
    @JsonPropertyDescription("JSON Schema const value")
    public Object constValue;

    /*
        Validation Keywords for Numeric Instances (number and integer)
     */

    /**
     * The value of "multipleOf" <b>MUST</b> be a number, strictly greater than 0.
     * <p>
     * A numeric instance is valid only if division by this keyword's value results in an integer.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.2.1">multipleOf</a>
     */
    @Nullable
    @Min(
            value = 1,
            message = "The value of \"multipleOf\" MUST be a number, strictly greater than 0."
    )
    @JsonProperty("multipleOf")
    public Number multipleOf;

    /**
     * The value of "maximum" <b>MUST</b> be a number, representing an inclusive upper limit for a numeric instance.
     * <p>
     * If the instance is a number, then this keyword validates only if the instance is less than or exactly equal to "maximum".
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.2.2">maximum</a>
     */
    @Nullable
    @JsonProperty("maximum")
    public BigDecimal maximum;

    /**
     * The value of "exclusiveMaximum" <b>MUST</b> be number, representing an exclusive upper limit for a numeric instance.
     * <br>
     * If the instance is a number, then the instance is valid only if it has a value strictly less than (not equal to) "exclusiveMaximum".
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.2.3">exclusiveMaximum</a>
     */
    @Nullable
    @JsonProperty("exclusiveMaximum")
    public BigDecimal exclusiveMaximum;

    /**
     * The value of "minimum" <b>MUST</b> be a number, representing an inclusive lower limit for a numeric instance.
     * <br>
     * If the instance is a number, then this keyword validates only if the instance is greater than or exactly equal to "minimum".
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.2.4">minimum</a>
     */
    @Nullable
    @JsonProperty("minimum")
    public BigDecimal minimum;

    /**
     * The value of "exclusiveMinimum" <b>MUST</b> be number, representing an exclusive lower limit for a numeric instance.
     * <br>
     * If the instance is a number, then the instance is valid only if it has a value strictly greater than (not equal to) "exclusiveMinimum".
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.2.5">exclusiveMinimum</a>
     */
    @Nullable
    @JsonProperty("exclusiveMinimum")
    public BigDecimal exclusiveMinimum;

    /*
        Validation Keywords for Strings
     */

    /**
     * The value of this keyword <b>MUST</b> be a non-negative integer.
     * <p>
     * A string instance is valid against this keyword if its length is less than, or equal to, the value of this keyword.
     * <p>
     * The length of a string instance is defined as the number of its characters as defined by <a href="https://tools.ietf.org/html/rfc7159">RFC 7159</a> [RFC7159].
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.3.1">maxLength</a>
     */
    @Nullable
    @Min(
            value = 0,
            message = "The value of \"maxLength\" MUST be a non-negative integer."
    )
    @JsonProperty("maxLength")
    public Integer maxLength;

    /**
     * The value of this keyword <b>MUST</b> be a non-negative integer.
     * <p>
     * A string instance is valid against this keyword if its length is greater than, or equal to, the value of this keyword.
     * <p>
     * The length of a string instance is defined as the number of its characters as defined by <a href="https://tools.ietf.org/html/rfc7159">RFC 7159</a> [RFC7159].
     * <p>
     * Omitting this keyword has the same behavior as a value of 0.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.3.2">minLength</a>
     */
    @Nullable
    @Min(
            value = 0,
            message = "The value of \"minLength\" MUST be a non-negative integer."
    )
    @JsonProperty("minLength")
    public Integer minLength;

    /**
     * The value of this keyword <b>MUST</b> be a string.
     * <p>
     * This string <b>SHOULD</b> be a valid regular expression, according to the ECMA 262 regular expression dialect.
     * <p>
     * A string instance is considered valid if the regular expression matches the instance successfully.
     * Recall: regular expressions are not implicitly anchored.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.3.3">pattern</a>
     */
    @Nullable
    @JsonProperty("pattern")
    public String pattern;

    /*
        Validation Keywords for Arrays
     */

    /**
     * The value of "items" <b>MUST</b> be either a valid JSON Schema or an array of valid JSON Schemas.
     * <p>
     * This keyword determines how child instances validate for arrays, and does not directly validate the immediate instance itself.
     * <p>
     * If "items" is a schema, validation succeeds if all elements in the array successfully validate against that schema.
     * <p>
     * If "items" is an array of schemas, validation succeeds if each element of the instance validates against the schema at the same
     * position, if any.
     * <p>
     * Omitting this keyword has the same behavior as an empty schema.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.4.1">items</a>
     */
    @Nullable
    @JsonProperty("items")
    @JsonDeserialize(using = SchemaItemsDeserializer.class)
    public Object items;

    /**
     * The value of "additionalItems" <b>MUST</b> be a valid JSON Schema.
     * <p>
     * This keyword determines how child instances validate for arrays, and does not directly validate the immediate instance itself.
     * <p>
     * If "items" is an array of schemas, validation succeeds if every instance element at a position greater than the size of "items"
     * validates against "additionalItems".
     * <p>
     * Otherwise, "additionalItems" MUST be ignored, as the "items" schema (possibly the default value of an empty schema) is applied
     * to all elements.
     * <p>
     * Omitting this keyword has the same behavior as an empty schema.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.4.2">additionalItems</a>
     */
    @Nullable
    @JsonProperty("additionalItems")
    public Schema additionalItems;

    /**
     * The value of this keyword <b>MUST</b> be a non-negative integer.
     * <p>
     * An array instance is valid against "maxItems" if its size is less than, or equal to, the value of this keyword.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.4.3">maxItems</a>
     */
    @Nullable
    @Min(
            value = 0,
            message = "The value of \"maxItems\" MUST be a non-negative integer."
    )
    @JsonProperty("maxItems")
    public Integer maxItems;

    /**
     * The value of this keyword <b>MUST</b> be a non-negative integer.
     * <p>
     * An array instance is valid against "minItems" if its size is greater than, or equal to, the value of this keyword.
     * <p>
     * Omitting this keyword has the same behavior as a value of 0.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.4.4">minItems</a>
     */
    @Nullable
    @JsonProperty("minItems")
    public Integer minItems;

    /**
     * The value of this keyword <b>MUST</b> be a boolean.
     * <p>
     * If this keyword has boolean value false, the instance validates successfully.
     * <p>
     * If it has boolean value true, the instance validates successfully if all of its elements are unique.
     * <p>
     * Omitting this keyword has the same behavior as a value of false.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.4.5">uniqueItems</a>
     */
    @Nullable
    @JsonProperty("uniqueItems")
    public Boolean uniqueItems;

    /**
     * The value of this keyword <b>MUST</b> be a valid JSON Schema.
     * <br>
     * An array instance is valid against "contains" if at least one of its elements is valid against the given schema.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.4.6">contains</a>
     */
    @Nullable
    @JsonProperty("contains")
    public Schema contains;

    /*
        Validation Keywords for Objects
     */

    /**
     * The value of this keyword <b>MUST</b> be a non-negative integer.
     * <p>
     * An object instance is valid against "maxProperties" if its number of properties is less than, or equal to,
     * the value of this keyword.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.5.1">maxProperties</a>
     */
    @Nullable
    @Min(
            value = 0,
            message = "The value of \"maxProperties\" MUST be a non-negative integer."
    )
    @JsonProperty("maxProperties")
    public Integer maxProperties;

    /**
     * The value of this keyword <b>MUST</b> be a non-negative integer.
     * <p>
     * An object instance is valid against "minProperties" if its number of properties is greater than, or equal to,
     * the value of this keyword.
     * <p>
     * Omitting this keyword has the same behavior as a value of 0.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.5.2">minProperties</a>
     */
    @Nullable
    @Min(
            value = 0,
            message = "The value of \"minProperties\" MUST be a non-negative integer."
    )
    @JsonProperty("minProperties")
    public Integer minProperties;

    /**
     * The value of this keyword <b>MUST</b> be an array. Elements of this array, if any, <b>MUST</b> be strings, and <b>MUST</b> be unique.
     * <p>
     * An object instance is valid against this keyword if every item in the array is the name of a property in the instance.
     * <p>
     * Omitting this keyword has the same behavior as an empty array.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.5.3">required</a>
     */
    @Nullable
    @JsonProperty("required")
    public List<String> required;

    /**
     * The value of "properties" <b>MUST</b> be an object. Each value of this object <b>MUST</b> be a valid JSON Schema.
     * <p>
     * This keyword determines how child instances validate for objects, and does not directly validate the immediate
     * instance itself.
     * <p>
     * Validation succeeds if, for each name that appears in both the instance and as a name within this keyword's value,
     * the child instance for that name successfully validates against the corresponding schema.
     * <p>
     * Omitting this keyword has the same behavior as an empty object.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.5.4">properties</a>
     */
    @Nullable
    @JsonProperty("properties")
    public Map<String, Schema> properties;

    /**
     * The value of "patternProperties" <b>MUST</b> be an object.
     * <p>
     * Each property name of this object <b>SHOULD</b> be a valid regular expression, according to the ECMA 262 regular expression dialect.
     * <p>
     * Each property value of this object <b>MUST</b> be a valid JSON Schema.
     * <p>
     * This keyword determines how child instances validate for objects, and does not directly validate the immediate
     * instance itself.  Validation of the primitive instance type against this keyword always succeeds.
     * <p>
     * Validation succeeds if, for each instance name that matches any regular expressions that appear as a property name
     * in this keyword's value, the child instance for that name successfully validates against each schema that corresponds
     * to a matching regular expression.
     * <p>
     * Omitting this keyword has the same behavior as an empty object.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.5.5">patternProperties</a>
     */
    @Nullable
    @JsonProperty("patternProperties")
    public Map<String, Schema> patternProperties;

    /**
     * <font color="red"><b>This property has been overwritten by AsyncAPI Specification - maybe boolean value</b></font>
     * <p>
     * <p>
     * The value of "additionalProperties" MUST be a valid JSON Schema.
     * <p>
     * This keyword determines how child instances validate for objects, and does not directly validate the immediate
     * instance itself.
     * <p>
     * Validation with "additionalProperties" applies only to the child values of instance names that do not match any
     * names in "properties", and do not match any regular expression in "patternProperties".
     * <p>
     * For all such properties, validation succeeds if the child instance validates against the "additionalProperties" schema.
     * <p>
     * Omitting this keyword has the same behavior as an empty schema.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.5.6">additionalProperties</a>
     */
    @Nullable
    @JsonProperty("additionalProperties")
    @JsonDeserialize(using = SchemasAdditionalPropertiesDeserializer.class)
    public Object additionalProperties;

    /**
     * [CREF1] - This keyword may be split into two, with the variation that uses an array of property names rather than a
     * subschema getting a new name.  The dual behavior is confusing and relatively difficult to implement.  In the previous
     * draft, we proposed dropping the keyword altogether, or dropping one of its forms, but we received feedback in support of
     * keeping it.  See issues #442 and #528 at https://github.com/json-schema-org/json-schema-spec/issues for further discussion.
     * Further feedback is encouraged.
     * <p>
     * <p>
     * <p>
     * This keyword specifies rules that are evaluated if the instance is an object and contains a certain property.
     * <p>
     * This keyword's value <b>MUST</b> be an object. Each property specifies a dependency. Each dependency value <b>MUST</b> be an array
     * or a valid JSON Schema.
     * <p>
     * If the dependency value is a subschema, and the dependency key is a property in the instance, the entire instance must validate
     * against the dependency value.
     * <p>
     * If the dependency value is an array, each element in the array, if any, <b>MUST</b> be a string, and <b>MUST</b> be unique.
     * <p>
     * If the dependency key is a property in the instance, each of the items in the dependency value must be a property that exists in the instance.
     * <p>
     * Omitting this keyword has the same behavior as an empty object.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.5.7">dependencies</a>
     */
    @Nullable
    @JsonProperty("dependencies")
    public Object dependencies;

    /**
     * The value of "propertyNames" <b>MUST</b> be a valid JSON Schema.
     * <p>
     * If the instance is an object, this keyword validates if every property name in the instance validates against the provided schema.
     * <p>
     * Note the property name that the schema is testing will always be a string.
     * <p>
     * Omitting this keyword has the same behavior as an empty schema.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.6.5.8">propertyNames</a>
     */
    @Nullable
    @JsonProperty("propertyNames")
    public Schema propertyNames;

    /*
        Keywords for Applying Subschemas Conditionally
     */

    /**
     * This keyword's value <b>MUST</b> be a valid JSON Schema.
     * <p>
     * This validation outcome of this keyword's subschema has no direct effect on the overall validation result.
     * Rather, it controls which of the "then" or "else" keywords are evaluated.
     * <p>
     * Instances that successfully validate against this keyword's subschema <b>MUST</b> also be valid against the subschema
     * value of the "then" keyword, if present.
     * <p>
     * Instances that fail to validate against this keyword's subschema <b>MUST</b> also be valid against the subschema value of
     * the "else" keyword, if present.
     * <p>
     * If annotations (<a href="https://tools.ietf.org/html/draft-handrews-json-schema-validation-01#section-3.3">Section 3.3</a>) are being collected, they are collected from this keyword's subschema in the usual way,
     * including when the keyword is present without either "then" or "else".
     */
    @Nullable
    @JsonProperty("if")
    public Schema ifValue;

    /**
     * This keyword's value <b>MUST</b> be a valid JSON Schema.
     * <p>
     * When "if" is present, and the instance successfully validates against its subschema, then valiation succeeds against
     * this keyword if the instance also successfully validates against this keyword's subschema.
     * <p>
     * This keyword has no effect when "if" is absent, or when the instance fails to validate against its subschema.
     * Implementations MUST NOT evaluate the instance against this keyword, for either validation or annotation collection
     * purposes, in such cases.
     */
    @Nullable
    @JsonProperty("then")
    public Schema thenValue;

    /**
     * This keyword's value <b>MUST</b> be a valid JSON Schema.
     * <p>
     * When "if" is present, and the instance fails to validate against its subschema, then valiation succeeds against this
     * keyword if the instance successfully validates against this keyword's subschema.
     * <p>
     * This keyword has no effect when "if" is absent, or when the instance successfully validates against its subschema.
     * Implementations <b>MUST NOT</b> evaluate the instance against this keyword, for either validation or annotation collection
     * purposes, in such cases.
     */
    @Nullable
    @JsonProperty("else")
    public Schema elseValue;

    /*
        Schema Annotations

        Schema validation is a useful mechanism for annotating instance data
        with additional information.  The rules for determining when and how
        annotations are associated with an instance are outlined in section
        3.3.

        These general-purpose annotation keywords provide commonly used
        information for documentation and user interface display purposes.
        They are not intended to form a comprehensive set of features.
        Rather, additional vocabularies can be defined for more complex
        annotation-based applications.
     */

    /**
     * The value of these keyword MUST be a string.
     * <br><br>
     * This keywords can be used to decorate a user interface with information about the data produced by this user
     * interface.
     * <br><br>
     * A title will preferably be short
     */
    @Nullable
    @JsonProperty
    public String title;

    /**
     * The value of these keyword MUST be a string.
     * <br><br>
     * <b>This property definition was adjusted to the AsyncAPI Specification.</b>
     * <a href="http://spec.commonmark.org/">CommonMark syntax can</a> be used for rich text representation.
     * <br><br>
     * This keywords can be used to decorate a user interface with information about the data produced by this user
     * interface.
     * <br><br>
     * A description will provide explanation about the purpose of the instance described by this schema.
     */
    @Nullable
    @JsonProperty
    public String description;

    /**
     * There are no restrictions placed on the value of this keyword.  When multiple occurrences of this keyword are
     * applicable to a single sub-instance, implementations SHOULD remove duplicates.
     * <br><br>
     * This keyword can be used to supply a default JSON value associated with a particular schema.
     * It is RECOMMENDED that a default value be valid against the associated schema.
     * <br><br>
     * <b>This property definition was adjusted to the AsyncAPI Specification.</b>
     * The default value represents what would be assumed by the consumer of the input as the value of the schema if one
     * is not provided. Unlike JSON Schema, the value MUST conform to the defined type for the Schema Object defined at
     * the same level. For example, of type is <code>string</code>, then default can be <code>"foo"</code> but cannot be <code>1</code>.
     */
    @Nullable
    @JsonProperty("default")
    public Object defaultValue;

    /**
     * The value of this keyword MUST be a boolean. When multiple occurrences of this keyword are applicable to a
     * single sub-instance, the resulting value MUST be true if any occurrence specifies a true value, and MUST be false otherwise.
     * <br><br>
     * If "readOnly" has a value of boolean true, it indicates that the value of the instance is managed exclusively by the owning authority,
     * and attempts by an application to modify the value of this property are expected to be ignored or rejected by that owning authority.
     * <br><br>
     * An instance document that is marked as "readOnly for the entire document MAY be ignored if sent to the owning authority, or MAY
     * result in an error, at the authority's discretion.
     * <br><br>
     * For example, "readOnly" would be used to mark a database-generated serial number as read-only, while "writeOnly" would be used to mark a
     * password input field.
     * <br><br>
     * This keyword can be used to assist in user interface instance generation. In particular, an application MAY choose to use a widget
     * that hides input values as they are typed for write-only fields.
     * <br><br>
     * Omitting this keyword has the same behavior as values of false.
     */
    @Nullable
    @JsonProperty
    public Boolean readOnly;

    /**
     * The value of this keyword MUST be a boolean. When multiple occurrences of this keyword are applicable to a
     * single sub-instance, the resulting value MUST be true if any occurrence specifies a true value, and MUST be false otherwise.
     * <br><br>
     * If "writeOnly" has a value of boolean true, it indicates that the value is never present when the instance is retrieved from the owning
     * authority.  It can be present when sent to the owning authority to update or create the document (or the resource it represents), but it
     * will not be included in any updated or newly created version of the instance.
     * <br><br>
     * An instance document that is marked as "writeOnly" for the entire document MAY be returned as a blank document of some sort, or MAY
     * produce an error upon retrieval, or have the retrieval request ignored, at the authority's discretion.
     * <br><br>
     * This keyword can be used to assist in user interface instance generation. In particular, an application MAY choose to use a widget
     * that hides input values as they are typed for write-only fields.
     * <br><br>
     * Omitting this keyword has the same behavior as values of false.
     */
    @Nullable
    @JsonProperty
    public Boolean writeOnly;

    /**
     * The value of this keyword MUST be an array.  There are no restrictions placed on the values within the array.
     * When multiple occurrences of this keyword are applicable to a single sub-instance, implementations MUST provide
     * a flat array of all values rather than an array of arrays.
     * <br><br>
     * This keyword can be used to provide sample JSON values associated with a particular schema, for the purpose of
     * illustrating usage. It is RECOMMENDED that these values be valid against the associated schema.
     * <br><br>
     * Implementations MAY use the value(s) of "default", if present, as an additional example.  If "examples" is absent,
     * "default" MAY still be used in this manner.
     */
    @Nullable
    @JsonProperty
    public List<Object> examples;

    /*
        String-Encoding Non-JSON Data

        Foreword

        Properties defined in this section indicate that an instance contains
        non-JSON data encoded in a JSON string.  They describe the type of
        content and how it is encoded.

        These properties provide additional information required to interpret
        JSON data as rich multimedia documents.

        Implementation Requirements

        The content keywords function as both annotations (Section 3.3) and
        as assertions (Section 3.2).  While no special effort is required to
        implement them as annotations conveying how applications can
        interpret the data in the string, implementing validation of
        conformance to the media type and encoding is non-trivial.

        Implementations MAY support the "contentMediaType" and
        "contentEncoding" keywords as validation assertions.  Should they
        choose to do so, they SHOULD offer an option to disable validation
        for these keywords.
     */

    /**
     * If the instance value is a string, this property defines that the string SHOULD be interpreted as binary data and
     * decoded using the encoding named by this property. <a href="https://tools.ietf.org/html/rfc2045">RFC 2045</a>, Sec 6.1 [<a href="https://tools.ietf.org/html/rfc2045">RFC2045</a>] lists the possible values for this property.
     * <br><br>
     * The value of this property MUST be a string.
     * <br><br>
     * The value of this property SHOULD be ignored if the instance described is not a string.
     */
    @Nullable
    @JsonProperty
    private String contentEncoding;

    /**
     * The value of this property must be a media type, as defined by <a href="https://tools.ietf.org/html/rfc2046">RFC 2046</a> [<a href="https://tools.ietf.org/html/rfc2046">RFC2046</a>]. This property defines the media
     * type of instances which this schema defines.
     * <br><br>
     * The value of this property MUST be a string.
     * <br><br>
     * The value of this property SHOULD be ignored if the instance described is not a string.
     * <br><br>
     * If the "contentEncoding" property is not present, but the instance value is a string, then the value of this property SHOULD specify a
     * text document type, and the character set SHOULD be the character set into which the JSON string value was decoded (for which the default
     * is Unicode).
     */
    @Nullable
    @JsonProperty
    private String contentMediaType;

    /*
        Keywords for Applying Subschemas With Boolean Logic
     */

    /**
     * This keyword's value MUST be a non-empty array.  Each item of the array MUST be a valid JSON Schema.
     * <br><br>
     * An instance validates successfully against this keyword if it validates successfully against all schemas defined
     * by this keyword's value.
     */
    @Nullable
    @JsonProperty
    public List<Schema> allOf;

    /**
     * This keyword's value MUST be a non-empty array.  Each item of the array MUST be a valid JSON Schema.
     * <br><br>
     * An instance validates successfully against this keyword if it validates successfully against at least one schema
     * defined by this keyword's value.
     */
    @Nullable
    @JsonProperty
    public List<Schema> anyOf;

    /**
     * This keyword's value MUST be a non-empty array.  Each item of the array MUST be a valid JSON Schema.
     * <br><br>
     * An instance validates successfully against this keyword if it validates successfully against exactly one schema
     * defined by this keyword's value.
     */
    @Nullable
    @JsonProperty
    public List<Schema> oneOf;

    /**
     * This keyword's value MUST be a valid JSON Schema.
     * <br><br>
     * An instance is valid against this keyword if it fails to validate successfully against the schema defined by this keyword.
     */
    @Nullable
    @JsonProperty
    public Schema not;

    // Fields defined in AsyncAPI below

    /*
        The following properties are taken from the JSON Schema definition but their definitions were adjusted to the AsyncAPI Specification.
     */
    /**
     * See <a href ="https://www.asyncapi.com/docs/specifications/2.0.0#dataTypeFormat">Data Type Formats</a> for further details.
     * While relying on JSON Schema's defined formats, the AsyncAPI Specification offers a few additional predefined formats.
     */
    @Nullable
    @JsonProperty
    public Object format;

    /*
        In addition to the JSON Schema fields, the following AsyncAPI vocabulary fields MAY be used for further schema documentation:
     */
    /**
     * Adds support for polymorphism. The discriminator is the schema property name that is used to differentiate between
     * other schema that inherit this schema.
     * <br><br>
     * The property name used MUST be defined at this schema and it MUST be in the <code>required</code> property list.
     * When used, the value MUST be the name of this schema or any schema that inherits it. See <a href="https://www.asyncapi.com/docs/specifications/2.0.0#schemaComposition">Composition and Inheritance for more details</a>.
     */
    @Nullable
    @JsonProperty
    public String discriminator;
    /**
     * Additional external documentation for this schema.
     */
    @Nullable
    @JsonProperty
    public ExternalDocumentation externalDocs;

    /**
     * Specifies that a schema is deprecated and SHOULD be transitioned out of usage. Default value is <code>false</code>.
     */
    @Nullable
    @JsonProperty
    public Boolean deprecated;

}
