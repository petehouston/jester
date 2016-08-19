package com.dreweaster.jester.example.domain.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link AbstractRegisterUser}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code RegisterUser.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "AbstractRegisterUser"})
public final class RegisterUser extends AbstractRegisterUser {
  private final String username;
  private final String password;

  private RegisterUser(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * @return The value of the {@code username} attribute
   */
  @Override
  public String username() {
    return username;
  }

  /**
   * @return The value of the {@code password} attribute
   */
  @Override
  public String password() {
    return password;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractRegisterUser#username() username} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for username
   * @return A modified copy of the {@code this} object
   */
  public final RegisterUser withUsername(String value) {
    if (this.username.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "username");
    return new RegisterUser(newValue, this.password);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractRegisterUser#password() password} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for password
   * @return A modified copy of the {@code this} object
   */
  public final RegisterUser withPassword(String value) {
    if (this.password.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "password");
    return new RegisterUser(this.username, newValue);
  }

  /**
   * This instance is equal to all instances of {@code RegisterUser} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof RegisterUser
        && equalTo((RegisterUser) another);
  }

  private boolean equalTo(RegisterUser another) {
    return username.equals(another.username)
        && password.equals(another.password);
  }

  /**
   * Computes a hash code from attributes: {@code username}, {@code password}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + username.hashCode();
    h = h * 17 + password.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code RegisterUser} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "RegisterUser{"
        + "username=" + username
        + ", password=" + password
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link AbstractRegisterUser} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RegisterUser instance
   */
  public static RegisterUser copyOf(AbstractRegisterUser instance) {
    if (instance instanceof RegisterUser) {
      return (RegisterUser) instance;
    }
    return RegisterUser.builder()
        .from(instance)
        .create();
  }

  /**
   * Creates a builder for {@link RegisterUser RegisterUser}.
   * @return A new RegisterUser builder
   */
  public static RegisterUser.Builder builder() {
    return new RegisterUser.Builder();
  }

  /**
   * Builds instances of type {@link RegisterUser RegisterUser}.
   * Initialize attributes and then invoke the {@link #create()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_USERNAME = 0x1L;
    private static final long INIT_BIT_PASSWORD = 0x2L;
    private long initBits = 0x3L;

    private String username;
    private String password;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AbstractRegisterUser} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractRegisterUser instance) {
      Objects.requireNonNull(instance, "instance");
      username(instance.username());
      password(instance.password());
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractRegisterUser#username() username} attribute.
     * @param username The value for username 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder username(String username) {
      this.username = Objects.requireNonNull(username, "username");
      initBits &= ~INIT_BIT_USERNAME;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractRegisterUser#password() password} attribute.
     * @param password The value for password 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder password(String password) {
      this.password = Objects.requireNonNull(password, "password");
      initBits &= ~INIT_BIT_PASSWORD;
      return this;
    }

    /**
     * Builds a new {@link RegisterUser RegisterUser}.
     * @return An immutable instance of RegisterUser
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public RegisterUser create() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new RegisterUser(username, password);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_USERNAME) != 0) attributes.add("username");
      if ((initBits & INIT_BIT_PASSWORD) != 0) attributes.add("password");
      return "Cannot build RegisterUser, some of required attributes are not set " + attributes;
    }
  }
}
