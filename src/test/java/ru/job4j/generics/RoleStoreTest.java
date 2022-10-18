package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenNameRoleIsKirill() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Kirill");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsKirill() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        store.add(new Role("1", "Vadim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Kirill");
    }

    @Test
    void whenReplaceThenRoleNameIsVadim() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        store.replace("1", new Role("1", "Vadim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Vadim");
    }

    @Test
    void whenNoReplaceUserThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        store.replace("10", new Role("10", "Vadim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Kirill");
    }

    @Test
    void whenDeleteUserThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenRoleNameIsKirill() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Kirill");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        boolean rsl = store.replace("1", new Role("1", "Vadim"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        boolean rsl = store.replace("10", new Role("10", "Vadim"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Kirill"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }
}